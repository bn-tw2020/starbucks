package com.example.todo.starbucks.screen.order.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.todo.starbucks.R
import com.example.todo.starbucks.databinding.FragmentProductBinding
import com.example.todo.starbucks.domain.model.Order
import com.example.todo.starbucks.screen.order.OrderAdapter

class ProductFragment(private val completed: (Order) -> Unit) : Fragment() {

    private lateinit var binding: FragmentProductBinding
    private val orderAdapter by lazy { OrderAdapter(completed) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
    }

    private fun setAdapter() {
        binding.rvProduct.adapter = orderAdapter
        orderAdapter.submitList(
            listOf(
                Order("W0000030",
                    "https://image.istarbucks.co.kr/upload/store/skuimg/2020/09/[9300000002611]_20200918110429000.jpg",
                    "머그",
                    "Mug"),
                Order("W0000164",
                    "https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9300000003600]_20220413140543290.jpg",
                    "글라스",
                    "Glass"),
                Order("W0000031",
                    "https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[11132329]_20220406144652838.jpg",
                    "플라스틱 텀블러",
                    "Plastic Tumbler"),
            )
        )
    }
}