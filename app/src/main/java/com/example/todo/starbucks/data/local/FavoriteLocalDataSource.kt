package com.example.todo.starbucks.data.local

import com.example.todo.starbucks.data.database.FavoriteDao
import com.example.todo.starbucks.domain.model.DetailOrder
import kotlinx.coroutines.flow.Flow

class FavoriteLocalDataSource(
    private val dao: FavoriteDao
): FavoriteDataSource {

    override fun getFavoriteItem(productCD: String): Flow<Boolean> = dao.loadItem(productCD)

    override fun getFavoriteItems(): Flow<List<DetailOrder>> = dao.load()

    override suspend fun addFavoriteItem(detailOrder: DetailOrder) = dao.insert(detailOrder)

    override suspend fun removeFavoriteItem(detailOrder: DetailOrder) = dao.delete(detailOrder)

    override suspend fun removeAll() = dao.deleteAll()
}