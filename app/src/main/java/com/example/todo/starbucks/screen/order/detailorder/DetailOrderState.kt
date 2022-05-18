package com.example.todo.starbucks.screen.order.detailorder

import com.example.todo.starbucks.domain.model.DetailOrder

sealed class DetailOrderState {
    object Normal : DetailOrderState()
    object Loading : DetailOrderState()
    object ERROR : DetailOrderState()
    data class GetDetail(val detail: DetailOrder) : DetailOrderState()
}
