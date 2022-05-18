package com.example.todo.starbucks.di

import com.example.todo.starbucks.data.local.FavoriteDataSource
import com.example.todo.starbucks.data.local.FavoriteLocalDataSource
import com.example.todo.starbucks.data.repository.FavoriteRepositoryImpl
import com.example.todo.starbucks.data.repository.HomeRepositoryImpl
import com.example.todo.starbucks.domain.repository.FavoriteRepository
import com.example.todo.starbucks.domain.repository.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<FavoriteDataSource> { FavoriteLocalDataSource(get()) }
    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
    single<FavoriteRepository> { FavoriteRepositoryImpl(get(), get()) }
}