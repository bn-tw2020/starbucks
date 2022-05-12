package com.example.todo.starbucks.domain.model

data class Event(
    val title: String,
    val subtitle: String,
    val url: String,
)

data class Events(
    val events: List<Event>
)