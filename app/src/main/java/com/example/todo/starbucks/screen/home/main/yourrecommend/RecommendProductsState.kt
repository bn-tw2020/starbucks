package com.example.todo.starbucks.screen.home.main.yourrecommend

import com.example.todo.starbucks.domain.model.RecommendProducts

sealed class RecommendProductsState {
    object Normal: RecommendProductsState()
    object Loading: RecommendProductsState()
    data class GetRecommendProducts(val products: RecommendProducts): RecommendProductsState()
}
