package com.example.todo.starbucks.screen.home.main.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.starbucks.databinding.ItemEventsSectionBinding
import com.example.todo.starbucks.domain.model.Events

class EventsSectionAdapter(
    private val buttonClick: () -> Unit,
) : ListAdapter<Events, EventsSectionAdapter.EventsSectionViewHolder>(EventsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsSectionViewHolder {
        val binding =
            ItemEventsSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventsSectionViewHolder(binding, buttonClick)
    }

    override fun onBindViewHolder(holder: EventsSectionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class EventsSectionViewHolder(
        private val binding: ItemEventsSectionBinding,
        private val buttonClick: () -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        private val nestedAdapter = EventsItemAdapter()

        init {
            binding.rvEvents.adapter = nestedAdapter
            binding.btnSeeAll.setOnClickListener { buttonClick() }
        }

        fun bind(events: Events) {
            nestedAdapter.submitList(events.events)
        }
    }

}

class EventsDiffUtil : DiffUtil.ItemCallback<Events>() {
    override fun areItemsTheSame(oldItem: Events, newItem: Events): Boolean {
        return oldItem.events == newItem.events
    }

    override fun areContentsTheSame(oldItem: Events, newItem: Events): Boolean {
        return oldItem == newItem
    }
}