package com.example.todo.starbucks.screen.order.beverage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todo.starbucks.R
import com.example.todo.starbucks.databinding.FragmentBeverageBinding
import com.example.todo.starbucks.domain.model.Order
import com.example.todo.starbucks.screen.order.OrderAdapter

class BeverageFragment : Fragment() {

    private lateinit var binding: FragmentBeverageBinding
    private val orderAdapter by lazy { OrderAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentBeverageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
    }

    private fun setAdapter() {
        binding.rvBeverage.adapter = orderAdapter
        orderAdapter.submitList(
            listOf(
                Order("https://www.istarbucks.co.kr/upload/store/skuimg/2021/02/[9200000001636]_20210225093600536.jpg", "콜드 블루", "Cold Brew"),
                Order("https://www.istarbucks.co.kr/upload/store/skuimg/2021/04/[20]_20210415144112678.jpg", "에스프레소", "Espresso"),
                Order("https://www.istarbucks.co.kr/upload/store/skuimg/2021/04/[168004]_20210415134634723.jpg", "프라프치노", "Frappuccino"),
            )
        )
    }
}