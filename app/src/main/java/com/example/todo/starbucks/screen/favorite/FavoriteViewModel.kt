package com.example.todo.starbucks.screen.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.starbucks.domain.model.DetailOrder
import com.example.todo.starbucks.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val favoriteRepository: FavoriteRepository,
) : ViewModel() {

    private val _items = MutableStateFlow<OrdersState>(OrdersState.Normal)
    val items = _items.asStateFlow()

    private val _isFavorite = MutableStateFlow<Boolean>(true)
    val isFavorite = _isFavorite.asStateFlow()

    init {
        loadFavorite()
    }

    private fun loadFavorite() = viewModelScope.launch {
        _items.value = OrdersState.Loading
        favoriteRepository.getFavoriteItems().collect { result ->
            result
                .onSuccess { _items.value = OrdersState.GetOrders(it) }
                .onFailure { _items.value = OrdersState.ERROR }
        }
    }

    fun favoriteExist(detailOrder: DetailOrder) {
        viewModelScope.launch {
            favoriteRepository.getFavoriteExist(detailOrder.productCD).collect {
                _isFavorite.value = it
            }
        }
    }

    fun toggleFavoriteButton(detailOrder: DetailOrder) {
        viewModelScope.launch {
            favoriteExist(detailOrder)
            if (isFavorite.value) {
                favoriteRepository.removeFavoriteItem(detailOrder)

            } else {
                favoriteRepository.addFavoriteItem(detailOrder)
            }
        }
    }
}