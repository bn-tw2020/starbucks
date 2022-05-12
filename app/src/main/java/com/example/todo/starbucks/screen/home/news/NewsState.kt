package com.example.todo.starbucks.screen.home.news

import com.example.todo.starbucks.domain.model.NewNotice

sealed class NewsState {
    object Normal: NewsState()
    object Loading: NewsState()
    object ERROR: NewsState()
    data class GetNews(val news: List<NewNotice>): NewsState()
}
