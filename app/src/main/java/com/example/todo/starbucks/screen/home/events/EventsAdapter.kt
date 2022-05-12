package com.example.todo.starbucks.screen.home.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.starbucks.databinding.ItemEventsBinding
import com.example.todo.starbucks.domain.model.Event
import com.example.todo.starbucks.screen.home.main.events.EventDiffUtil

class EventsAdapter: ListAdapter<Event, EventsAdapter.EventsViewHolder>(EventDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val binding = ItemEventsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class EventsViewHolder(private val binding: ItemEventsBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.event = event
        }
    }
}