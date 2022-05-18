package com.example.todo.starbucks.screen.favorite

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.starbucks.databinding.ItemFavoriteBinding
import com.example.todo.starbucks.domain.model.DetailOrder
import kotlinx.coroutines.flow.StateFlow

class FavoriteAdapter(
    private val isFavorite: StateFlow<Boolean>,
    private val FavoriteExist: (DetailOrder) -> Unit,
    private val toggleCallback: (DetailOrder) -> Unit,
) :
    ListAdapter<DetailOrder, FavoriteAdapter.FavoriteViewHolder>(FavoriteDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding =
            ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FavoriteViewHolder(private val binding: ItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(detailOrder: DetailOrder) {
            FavoriteExist(detailOrder)
            binding.favorite = detailOrder
            binding.btnLike.isSelected = isFavorite.value
            binding.btnLike.setOnClickListener { toggleCallback(detailOrder) }
        }

    }

}

class FavoriteDiffUtil : DiffUtil.ItemCallback<DetailOrder>() {
    override fun areItemsTheSame(oldItem: DetailOrder, newItem: DetailOrder): Boolean {
        return oldItem.productCD == newItem.productCD
    }

    override fun areContentsTheSame(oldItem: DetailOrder, newItem: DetailOrder): Boolean {
        return oldItem == newItem
    }

}