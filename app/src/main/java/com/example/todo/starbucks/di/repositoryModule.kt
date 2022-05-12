package com.example.todo.starbucks.di

import com.example.todo.starbucks.data.repository.HomeRepositoryImpl
import com.example.todo.starbucks.domain.repository.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
}