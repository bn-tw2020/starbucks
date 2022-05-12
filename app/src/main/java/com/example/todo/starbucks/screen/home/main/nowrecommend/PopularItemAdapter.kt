package com.example.todo.starbucks.screen.home.main.nowrecommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.starbucks.databinding.ItemPopularMenuBinding
import com.example.todo.starbucks.domain.model.RecommendProduct
import com.example.todo.starbucks.screen.home.main.yourrecommend.TopRecommendItemDiffCallback

class PopularItemAdapter :
    ListAdapter<RecommendProduct, PopularItemAdapter.PopularItemViewHolder>(
        TopRecommendItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularItemViewHolder {
        val binding = ItemPopularMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PopularItemViewHolder(
        private val binding: ItemPopularMenuBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: RecommendProduct) {
            binding.product = product
        }
    }

}

class PopularItemDiffCallback : DiffUtil.ItemCallback<RecommendProduct>() {
    override fun areItemsTheSame(oldItem: RecommendProduct, newItem: RecommendProduct): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecommendProduct, newItem: RecommendProduct): Boolean {
        return oldItem == newItem
    }
}