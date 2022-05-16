package com.example.todo.starbucks.screen.home.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.todo.starbucks.R
import com.example.todo.starbucks.databinding.FragmentHomeBinding
import com.example.todo.starbucks.screen.home.main.events.EventsSectionAdapter
import com.example.todo.starbucks.screen.home.main.events.EventsState
import com.example.todo.starbucks.screen.home.main.mainevent.MainEventItemAdapter
import com.example.todo.starbucks.screen.home.main.mainevent.MainEventState
import com.example.todo.starbucks.screen.home.main.nowrecommend.PopularProductsState
import com.example.todo.starbucks.screen.home.main.nowrecommend.PopularSectionAdapter
import com.example.todo.starbucks.screen.home.main.yourrecommend.RecommendProductsState
import com.example.todo.starbucks.screen.home.main.yourrecommend.TopRecommendSectionAdapter
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModel<HomeViewModel>()
    private val topRecommendSectionAdapter: TopRecommendSectionAdapter by lazy { TopRecommendSectionAdapter() }
    private val mainEventItemAdapter: MainEventItemAdapter by lazy { MainEventItemAdapter() }
    private val eventsSectionAdapter: EventsSectionAdapter by lazy {
        EventsSectionAdapter { findNavController().navigate(R.id.action_home_to_events) }
    }
    private val popularSectionAdapter: PopularSectionAdapter by lazy { PopularSectionAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        observerData()
        binding.rvHome.adapter = ConcatAdapter(
            topRecommendSectionAdapter,
            mainEventItemAdapter,
            eventsSectionAdapter,
            popularSectionAdapter
        )
        binding.btnNew.setOnClickListener { findNavController().navigate(R.id.action_home_to_new) }
    }

    private fun observerData() {
        lifecycleScope.launchWhenStarted {
            viewModel.recommendProducts.collect { state ->
                when (state) {
                    is RecommendProductsState.Loading -> handlerLoading()
                    is RecommendProductsState.GetRecommendProducts -> recommendSuccess(state)
                    else -> Unit
                }
            }
        }

        lifecycleScope.launchWhenStarted  {
            viewModel.mainEvent.collect { state ->
                when (state) {
                    is MainEventState.Loading -> handlerLoading()
                    is MainEventState.GetMainEvent -> mainEventSuccess(state)
                    else -> Unit
                }
            }
        }

        lifecycleScope.launchWhenStarted  {
            viewModel.events.collect { state ->
                when (state) {
                    is EventsState.Loading -> handlerLoading()
                    is EventsState.GetEvents -> eventsSuccess(state)
                    else -> Unit
                }
            }
        }

        lifecycleScope.launchWhenStarted  {
            viewModel.popularProducts.collect { state ->
                when (state) {
                    is PopularProductsState.Loading -> handlerLoading()
                    is PopularProductsState.GetPopularProducts -> popularSuccess(state)
                    else -> Unit
                }
            }
        }
    }

    private fun handlerLoading() = with(binding) {
        rvHome.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    private fun recommendSuccess(state: RecommendProductsState.GetRecommendProducts) {
        visibility()
        topRecommendSectionAdapter.submitList(listOf(state.products))
        scrollUp()
    }

    private fun mainEventSuccess(state: MainEventState.GetMainEvent) {
        visibility()
        mainEventItemAdapter.submitList(listOf(state.url))
        scrollUp()
    }

    private fun eventsSuccess(state: EventsState.GetEvents) {
        visibility()
        eventsSectionAdapter.submitList(listOf(state.events))
        scrollUp()
    }

    private fun popularSuccess(state: PopularProductsState.GetPopularProducts) {
        visibility()
        popularSectionAdapter.submitList(listOf(state.products))
    }

    private fun visibility() = with(binding) {
        rvHome.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    private fun scrollUp() {
        binding.rvHome.smoothScrollToPosition(0)
    }
}