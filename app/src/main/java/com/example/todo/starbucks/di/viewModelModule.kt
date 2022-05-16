package com.example.todo.starbucks.di

import com.example.todo.starbucks.screen.home.events.EventsViewModel
import com.example.todo.starbucks.screen.home.main.HomeViewModel
import com.example.todo.starbucks.screen.home.news.NewsViewModel
import com.example.todo.starbucks.screen.order.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get()) }
    viewModel { NewsViewModel(get()) }
    viewModel { EventsViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}