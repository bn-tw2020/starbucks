package com.example.todo.starbucks.screen.home.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.todo.starbucks.R
import com.example.todo.starbucks.databinding.FragmentEventsBinding
import com.example.todo.starbucks.databinding.FragmentNewBinding
import com.example.todo.starbucks.screen.home.main.events.EventsState
import com.example.todo.starbucks.screen.home.main.mainevent.MainEventState
import com.example.todo.starbucks.screen.home.main.nowrecommend.PopularProductsState
import com.example.todo.starbucks.screen.home.main.yourrecommend.RecommendProductsState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsFragment : Fragment() {

    private lateinit var binding: FragmentEventsBinding
    private val viewModel by viewModel<EventsViewModel>()
    private val eventsAdapter by lazy { EventsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNavigation()
        setAdapter()
        observerData()
    }

    private fun setAdapter() {
        binding.rvEvents.adapter = eventsAdapter
    }

    private fun observerData() {
        lifecycleScope.launch {
            viewModel.events.collect { state ->
                when (state) {
                    is EventsState.GetEvents -> eventsSuccess(state)
                    else -> Unit
                }
            }
        }
    }

    private fun eventsSuccess(state: EventsState.GetEvents) {
        eventsAdapter.submitList(state.events.events)
    }

    private fun setNavigation() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}