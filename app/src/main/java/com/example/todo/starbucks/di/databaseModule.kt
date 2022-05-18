package com.example.todo.starbucks.di

import org.koin.dsl.module

import org.koin.android.ext.koin.androidApplication

val databaseModule = module {
    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }
}
