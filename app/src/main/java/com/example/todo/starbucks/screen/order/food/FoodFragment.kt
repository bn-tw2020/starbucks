package com.example.todo.starbucks.screen.order.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todo.starbucks.R
import com.example.todo.starbucks.databinding.FragmentFoodBinding
import com.example.todo.starbucks.domain.model.Order
import com.example.todo.starbucks.screen.order.OrderAdapter

class FoodFragment : Fragment() {

    private lateinit var binding: FragmentFoodBinding
    private val orderAdapter by lazy { OrderAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
    }

    private fun setAdapter() {
        binding.rvFood.adapter = orderAdapter
        orderAdapter.submitList(
            listOf(
                Order("https://image.istarbucks.co.kr/upload/store/skuimg/2021/07/[9300000003522]_20210723095824217.jpg", "브레드", "Bread"),
                Order("https://image.istarbucks.co.kr/upload/store/skuimg/2022/04/[9300000004033]_20220406125332883.jpg", "케이크", "Cake"),
                Order("https://image.istarbucks.co.kr/upload/store/skuimg/2021/04/[9300000000689]_20210421132252087.jpg", "샌드위치 & 샐러드", "Sandwich & Salad"),
            )
        )
    }
}