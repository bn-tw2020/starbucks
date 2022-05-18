package com.example.todo.starbucks.screen.favorite

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.todo.starbucks.R
import com.example.todo.starbucks.databinding.FragmentFavoriteBinding
import com.example.todo.starbucks.domain.model.DetailOrder
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val viewModel by viewModel<FavoriteViewModel>()
    private val favoriteAdapter by lazy {
        FavoriteAdapter(
            viewModel.isFavorite,
            { detailOrder: DetailOrder -> viewModel.favoriteExist(detailOrder) },
            { detailOrder: DetailOrder -> viewModel.toggleFavoriteButton(detailOrder) }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observerData()
        setAdapter()
        binding.rvFavorite.addItemDecoration(DividerItemDecoration(requireContext(),
            LinearLayout.VERTICAL))
    }

    private fun setAdapter() {
        binding.rvFavorite.adapter = favoriteAdapter
    }

    private fun observerData() {
        lifecycleScope.launchWhenStarted {
            viewModel.items.collect { state ->
                when (state) {
                    is OrdersState.Loading -> Unit
                    is OrdersState.GetOrders -> handlerSuccess(state)
                    else -> Unit
                }
            }
        }

    }

    private fun handlerSuccess(state: OrdersState.GetOrders) {
        favoriteAdapter.submitList(state.orders)
    }
}