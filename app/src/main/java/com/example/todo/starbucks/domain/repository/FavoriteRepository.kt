package com.example.todo.starbucks.domain.repository

import com.example.todo.starbucks.domain.model.DetailOrder
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    fun getFavoriteExist(productCD: String): Flow<Boolean>

    fun getFavoriteItems(): Flow<Result<List<DetailOrder>>>

    suspend fun addFavoriteItem(detailOrder: DetailOrder)

    suspend fun removeFavoriteItem(detailOrder: DetailOrder)

    suspend fun removeAll()
}