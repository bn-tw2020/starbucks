package com.example.todo.starbucks.screen.order.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.todo.starbucks.R
import com.example.todo.starbucks.databinding.FragmentDetailBinding
import com.example.todo.starbucks.domain.model.Order
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val detailAdapter by lazy {
        DetailAdapter { order ->
            Order
            findNavController().navigate(R.id.action_detail_to_detailOrderFragment,
                bundleOf("order" to order))
        }
    }
    private val order by lazy { requireArguments().getSerializable("order") as Order }
    private val viewModel by viewModel<DetailViewModel> { parametersOf(order) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavigation()
        observerData()

        binding.tvName.text = order.titleKR
        binding.rvMenus.adapter = detailAdapter

    }

    private fun observerData() {
        lifecycleScope.launchWhenStarted {
            viewModel.orders.collect { state ->
                when (state) {
                    is DetailState.Loading -> handlerLoading()
                    is DetailState.GetOrder -> handlerSuccess(state)
                    is DetailState.ERROR -> handlerError()
                }
            }
        }
    }

    private fun handlerLoading() = with(binding) {
        rvMenus.visibility = View.GONE
        btnRetry.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    private fun handlerError() = with(binding) {
        progressBar.visibility = View.GONE
        btnRetry.visibility = View.VISIBLE
        rvMenus.visibility = View.GONE
        Toast.makeText(context, "서버와 연결을 확인해주세요.", Toast.LENGTH_SHORT).show()
        binding.btnRetry.setOnClickListener { viewModel.getOrders(order) }
    }

    private fun handlerSuccess(state: DetailState.GetOrder) = with(binding) {
        btnRetry.visibility = View.GONE
        progressBar.visibility = View.GONE
        rvMenus.visibility = View.VISIBLE
        detailAdapter.submitList(state.orders)
    }

    private fun setNavigation() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}