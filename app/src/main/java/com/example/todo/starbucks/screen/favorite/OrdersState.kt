package com.example.todo.starbucks.screen.favorite

import com.example.todo.starbucks.domain.model.DetailOrder

sealed class OrdersState {
    object Normal : OrdersState()
    object Loading : OrdersState()
    object ERROR : OrdersState()
    data class GetOrders(val orders: List<DetailOrder>) : OrdersState()
}


