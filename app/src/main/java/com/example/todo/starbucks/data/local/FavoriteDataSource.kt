package com.example.todo.starbucks.data.local

import com.example.todo.starbucks.domain.model.DetailOrder
import kotlinx.coroutines.flow.Flow

interface FavoriteDataSource {

    fun getFavoriteItem(productCD: String): Flow<Boolean>

    fun getFavoriteItems(): Flow<List<DetailOrder>>

    suspend fun addFavoriteItem(detailOrder: DetailOrder)

    suspend fun removeFavoriteItem(detailOrder: DetailOrder)

    suspend fun removeAll()
}