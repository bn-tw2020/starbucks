package com.example.todo.starbucks.screen.home.main.events

import com.example.todo.starbucks.domain.model.Events

sealed class EventsState {
    object Normal: EventsState()
    object Loading: EventsState()
    object ERROR: EventsState()
    data class GetEvents(val events: Events): EventsState()
}
