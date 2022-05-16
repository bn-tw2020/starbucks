package com.example.todo.starbucks.screen.order

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.starbucks.databinding.ItemOrderBinding
import com.example.todo.starbucks.domain.model.Order

class OrderAdapter(
    private val completed: (Order) -> Unit
) : ListAdapter<Order, OrderAdapter.OrderViewHolder>(OrderDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class OrderViewHolder(
        private val binding: ItemOrderBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(order: Order) {
            binding.order = order
            itemView.setOnClickListener { completed(order) }
        }
    }

}

class OrderDiffUtil : DiffUtil.ItemCallback<Order>() {
    override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
        return oldItem.titleKR == newItem.titleKR
    }

    override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
        return oldItem == newItem
    }

}