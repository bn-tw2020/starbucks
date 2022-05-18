package com.example.todo.starbucks.data.database

import androidx.room.*
import com.example.todo.starbucks.domain.model.DetailOrder
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorite_item")
    fun load(): Flow<List<DetailOrder>>

    @Query("SELECT EXISTS(SELECT * FROM favorite_item WHERE product_cd = :productCD)")
    fun loadItem(productCD: String): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(detailOrder: DetailOrder)

    @Delete
    suspend fun delete(detailOrder: DetailOrder)

    @Query("DELETE FROM favorite_item")
    suspend fun deleteAll()
}