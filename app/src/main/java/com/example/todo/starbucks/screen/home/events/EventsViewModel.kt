package com.example.todo.starbucks.screen.home.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.starbucks.domain.model.Event
import com.example.todo.starbucks.domain.model.Events
import com.example.todo.starbucks.domain.repository.HomeRepository
import com.example.todo.starbucks.screen.home.main.events.EventsState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EventsViewModel(
    private val homeRepository: HomeRepository,
) : ViewModel() {

    private val _events = MutableStateFlow<EventsState>(EventsState.Normal)
    val events: StateFlow<EventsState> = _events

    init {
        getEvents()
    }

    private fun getEvents() = viewModelScope.launch {
        _events.value = EventsState.Loading
        homeRepository.getEvents().collect { result ->
            result.onSuccess { events ->
                val eventList = events.events.map { event ->
                    Event(
                        event.title.toString(),
                        event.sbtitleNAME.toString(),
                        "https://image.istarbucks.co.kr/upload/promotion/${event.mobTHUM}")
                }
                _events.value = EventsState.GetEvents(Events(eventList))
            }
                .onFailure { _events.value = EventsState.ERROR }
        }
    }
}