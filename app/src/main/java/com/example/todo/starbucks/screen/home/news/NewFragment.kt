package com.example.todo.starbucks.screen.home.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.todo.starbucks.R
import com.example.todo.starbucks.databinding.FragmentNewBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewFragment : Fragment() {

    private lateinit var binding: FragmentNewBinding
    private val viewModel by viewModel<NewsViewModel>()
    private val newAdapter by lazy { NewAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setNavigation()
        setAdapter()
        observerData()
    }

    private fun observerData() {
        lifecycleScope.launch {
            viewModel.news.collect { state ->
                when (state) {
                    is NewsState.GetNews -> newsSuccess(state)
                    else -> Unit
                }
            }
        }
    }

    private fun newsSuccess(state: NewsState.GetNews) {
        newAdapter.submitList(state.news)
    }

    private fun setAdapter() {
        binding.rvNews.adapter = newAdapter
        binding.rvNews.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))
    }

    private fun setNavigation() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

}