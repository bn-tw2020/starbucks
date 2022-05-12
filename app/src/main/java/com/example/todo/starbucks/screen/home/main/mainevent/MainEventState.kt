package com.example.todo.starbucks.screen.home.main.mainevent

sealed class MainEventState {
    object Normal: MainEventState()
    object Loading: MainEventState()
    data class GetMainEvent(val url: String): MainEventState()
}
