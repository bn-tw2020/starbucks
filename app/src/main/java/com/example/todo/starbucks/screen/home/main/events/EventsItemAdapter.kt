package com.example.todo.starbucks.screen.home.main.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.starbucks.databinding.ItemEventBinding
import com.example.todo.starbucks.domain.model.Event

class EventsItemAdapter: ListAdapter<Event, EventsItemAdapter.EventsViewHolder>(EventDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class EventsViewHolder(private val binding: ItemEventBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.event = event
        }
    }
}

class EventDiffUtil: DiffUtil.ItemCallback<Event>() {
    override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem == newItem
    }
}