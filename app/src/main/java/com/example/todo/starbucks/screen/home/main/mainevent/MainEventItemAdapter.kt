package com.example.todo.starbucks.screen.home.main.mainevent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.starbucks.databinding.ItemMainEventBinding

class MainEventItemAdapter :
    ListAdapter<String, MainEventItemAdapter.MainEventViewHolder>(MainEventDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainEventViewHolder {
        val binding =
            com.example.todo.starbucks.databinding.ItemMainEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainEventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainEventViewHolder, position: Int) {

        holder.bind(getItem(position))
    }

    class MainEventViewHolder(private val binding: ItemMainEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(url: String) {
            binding.imageURL = url
        }
    }
}


class MainEventDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}