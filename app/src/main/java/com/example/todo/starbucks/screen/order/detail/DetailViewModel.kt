package com.example.todo.starbucks.screen.order.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.starbucks.domain.model.Order
import com.example.todo.starbucks.domain.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val homeRepository: HomeRepository,
) : ViewModel() {

    private val _orders = MutableStateFlow<DetailState>(DetailState.Normal)
    val orders: StateFlow<DetailState> = _orders

    fun getOrders(order: Order) {
        viewModelScope.launch {
            _orders.value = DetailState.Loading
            if (order.id == null) return@launch
            homeRepository.getOrders(order.id).collect { result ->
                result.onSuccess { _orders.value = DetailState.GetOrder(it) }
                    .onFailure { _orders.value = DetailState.ERROR }
            }
        }
    }
}