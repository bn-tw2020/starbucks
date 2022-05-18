package com.example.todo.starbucks.screen.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.example.todo.starbucks.R
import com.example.todo.starbucks.databinding.FragmentOrderBinding
import com.example.todo.starbucks.domain.model.Order
import com.google.android.material.tabs.TabLayoutMediator

class OrderFragment : Fragment() {

    private lateinit var binding: FragmentOrderBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val tabList = listOf("음료", "푸드", "상품")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        viewPagerAdapter = ViewPagerAdapter(context as FragmentActivity) { order: Order ->
            findNavController().navigate(R.id.action_order_to_detail,
                bundleOf("order" to order))
        }
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vpPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabKind, binding.vpPager) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }
}