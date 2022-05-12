package com.example.todo.starbucks.screen.home.main.yourrecommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.starbucks.databinding.ItemRecommendMenuBinding
import com.example.todo.starbucks.domain.model.RecommendProduct

class TopRecommendItemAdapter :
    ListAdapter<RecommendProduct, TopRecommendItemAdapter.RecommendItemViewHolder>(
        TopRecommendItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendItemViewHolder {
        val binding = ItemRecommendMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RecommendItemViewHolder(
        private val binding: ItemRecommendMenuBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: RecommendProduct) {
            binding.product = product
        }
    }

}

class TopRecommendItemDiffCallback : DiffUtil.ItemCallback<RecommendProduct>() {
    override fun areItemsTheSame(oldItem: RecommendProduct, newItem: RecommendProduct): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: RecommendProduct, newItem: RecommendProduct): Boolean {
        return oldItem == newItem
    }
}