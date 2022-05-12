package com.example.todo.starbucks.screen.home.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.starbucks.databinding.ItemNewsBinding
import com.example.todo.starbucks.domain.model.NewNotice

class NewAdapter : ListAdapter<NewNotice, NewAdapter.NewViewHolder>(NewDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NewViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(newNotice: NewNotice) {
            binding.newNotice = newNotice
        }
    }

}

class NewDiffUtil : DiffUtil.ItemCallback<NewNotice>() {
    override fun areItemsTheSame(oldItem: NewNotice, newItem: NewNotice): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NewNotice, newItem: NewNotice): Boolean {
        return oldItem == newItem
    }

}