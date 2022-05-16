package com.example.todo.starbucks.screen.order.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.starbucks.databinding.ItemOrderBinding
import com.example.todo.starbucks.domain.model.Order
import com.example.todo.starbucks.screen.order.OrderDiffUtil

class DetailAdapter: ListAdapter<Order, DetailAdapter.DetailViewHolder>(OrderDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DetailViewHolder(private val binding: ItemOrderBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(order: Order) {
            binding.order = order
        }
    }
}