package com.example.todo.starbucks.screen.home.main.yourrecommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.starbucks.databinding.ItemRecommendMenuSectionBinding
import com.example.todo.starbucks.domain.model.RecommendProducts

class TopRecommendSectionAdapter :
    ListAdapter<RecommendProducts, TopRecommendSectionAdapter.RecommendSectionViewHolder>(
        TopRecommendDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendSectionViewHolder {
        val binding = ItemRecommendMenuSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendSectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendSectionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RecommendSectionViewHolder(private val binding: ItemRecommendMenuSectionBinding) : RecyclerView.ViewHolder(binding.root) {

        private val nestedAdapter = TopRecommendItemAdapter()

        init {
            binding.rvRecommendSection.adapter = nestedAdapter
        }

        fun bind(products: RecommendProducts) {
            binding.products = products
            binding.executePendingBindings()
            nestedAdapter.submitList(products.products)
        }
    }
}

class TopRecommendDiffCallback : DiffUtil.ItemCallback<RecommendProducts>() {
    override fun areItemsTheSame(oldItem: RecommendProducts, newItem: RecommendProducts): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: RecommendProducts, newItem: RecommendProducts): Boolean {
        return oldItem == newItem
    }
}