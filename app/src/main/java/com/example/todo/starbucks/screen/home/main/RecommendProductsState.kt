package com.example.todo.starbucks.screen.home.main

import com.example.todo.starbucks.domain.model.RecommendProduct

sealed class RecommendProductsState {
    object Normal: RecommendProductsState()
    object Loading: RecommendProductsState()
    data class GetRecommendProducts(val products: List<RecommendProduct>): RecommendProductsState()
}
