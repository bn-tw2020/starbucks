package com.example.todo.starbucks.data.repository

import com.example.todo.starbucks.data.local.FavoriteDataSource
import com.example.todo.starbucks.domain.model.DetailOrder
import com.example.todo.starbucks.domain.repository.FavoriteRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class FavoriteRepositoryImpl(
    private val localDataSource: FavoriteDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : FavoriteRepository {
    override fun getFavoriteExist(productCD: String): Flow<Boolean>
        = localDataSource.getFavoriteItem(productCD)

    override fun getFavoriteItems(): Flow<Result<List<DetailOrder>>> = flow {
        localDataSource.getFavoriteItems()
            .flowOn(ioDispatcher)
            .collect { emit(runCatching { it }) }
    }

    override suspend fun addFavoriteItem(detailOrder: DetailOrder) {
        withContext(ioDispatcher) {
            localDataSource.addFavoriteItem(detailOrder)
        }
    }

    override suspend fun removeFavoriteItem(detailOrder: DetailOrder) {
        withContext(ioDispatcher) {
            localDataSource.removeFavoriteItem(detailOrder)
        }
    }

    override suspend fun removeAll() = withContext(ioDispatcher) { localDataSource.removeAll() }

}