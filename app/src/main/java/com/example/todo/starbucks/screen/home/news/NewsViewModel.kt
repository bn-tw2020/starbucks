package com.example.todo.starbucks.screen.home.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.starbucks.domain.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(
    private val homeRepository: HomeRepository,
): ViewModel() {

    private val _news = MutableStateFlow<NewsState>(NewsState.Normal)
    val news: StateFlow<NewsState> = _news

    init {
        getNews()
    }

    private fun getNews() = viewModelScope.launch {
        homeRepository.getNews().collect { result ->
            result.onSuccess {
                _news.value = NewsState.GetNews(it)
            }
                .onFailure {
                    _news.value = NewsState.ERROR
                }
        }
    }
}