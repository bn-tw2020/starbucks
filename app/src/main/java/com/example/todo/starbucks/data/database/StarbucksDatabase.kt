package com.example.todo.starbucks.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todo.starbucks.domain.model.DetailOrder

@Database(
    entities = [DetailOrder::class],
    version = 1
)
abstract class StarbucksDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}