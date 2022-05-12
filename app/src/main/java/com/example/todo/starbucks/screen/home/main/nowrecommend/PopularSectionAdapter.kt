package com.example.todo.starbucks.screen.home.main.nowrecommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.starbucks.databinding.ItemPopularMenuSectionBinding
import com.example.todo.starbucks.domain.model.RecommendProducts
import com.example.todo.starbucks.screen.home.main.yourrecommend.TopRecommendDiffCallback

class PopularSectionAdapter :
    ListAdapter<RecommendProducts, PopularSectionAdapter.PouplarSectionViewHolder>(
        TopRecommendDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PouplarSectionViewHolder {
        val binding = ItemPopularMenuSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PouplarSectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PouplarSectionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PouplarSectionViewHolder(private val binding: ItemPopularMenuSectionBinding) : RecyclerView.ViewHolder(binding.root) {

        private val nestedAdapter = PopularItemAdapter()

        init {
            binding.rvPopularMenu.adapter = nestedAdapter
        }

        fun bind(products: RecommendProducts) {
            binding.products = products
            nestedAdapter.submitList(products.products)
        }
    }
}

class PopularDiffCallback : DiffUtil.ItemCallback<RecommendProducts>() {
    override fun areItemsTheSame(oldItem: RecommendProducts, newItem: RecommendProducts): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: RecommendProducts, newItem: RecommendProducts): Boolean {
        return oldItem == newItem
    }
}