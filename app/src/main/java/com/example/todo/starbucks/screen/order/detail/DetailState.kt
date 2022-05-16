package com.example.todo.starbucks.screen.order.detail

import com.example.todo.starbucks.domain.model.Order

sealed class DetailState {
    object Normal : DetailState()
    object Loading : DetailState()
    object ERROR : DetailState()
    data class GetOrder(val orders: List<Order>) : DetailState()
}
