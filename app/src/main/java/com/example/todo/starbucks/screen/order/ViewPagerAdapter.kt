package com.example.todo.starbucks.screen.order

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.todo.starbucks.screen.order.beverage.BeverageFragment
import com.example.todo.starbucks.screen.order.food.FoodFragment
import com.example.todo.starbucks.screen.order.product.ProductFragment

class ViewPagerAdapter(
    fragmentActivity : FragmentActivity
): FragmentStateAdapter(fragmentActivity) {

    private val NUM_PAGES = 3

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> BeverageFragment()
            1 -> FoodFragment()
            else -> ProductFragment()
        }
    }
}