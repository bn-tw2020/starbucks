package com.example.todo.starbucks.screen.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.todo.starbucks.R
import com.example.todo.starbucks.databinding.FragmentOrderBinding
import com.google.android.material.tabs.TabLayoutMediator

class OrderFragment : Fragment() {

    private lateinit var binding: FragmentOrderBinding
    private val viewPagerAdapter by lazy { ViewPagerAdapter(context as FragmentActivity ) }
    private val tabList = listOf("음료", "푸드", "상품")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        TabLayoutMediator(binding.tabKind, binding.vpPager) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }

    private fun setAdapter() {
        binding.vpPager.adapter = viewPagerAdapter
    }
}