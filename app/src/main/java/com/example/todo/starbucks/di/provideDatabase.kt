package com.example.todo.starbucks.di

import android.app.Application
import androidx.room.Room
import com.example.todo.starbucks.data.database.FavoriteDao
import com.example.todo.starbucks.data.database.StarbucksDatabase

fun provideDataBase(application: Application): StarbucksDatabase {
    return Room.databaseBuilder(application, StarbucksDatabase::class.java, "favorite-local").build()
}

fun provideDao(database: StarbucksDatabase): FavoriteDao = database.favoriteDao()