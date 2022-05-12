package com.example.todo.starbucks.screen.home.main.nowrecommend

import com.example.todo.starbucks.domain.model.RecommendProducts

sealed class PopularProductsState {
    object Normal: PopularProductsState()
    object Loading: PopularProductsState()
    data class GetPopularProducts(val products: RecommendProducts): PopularProductsState()
}
