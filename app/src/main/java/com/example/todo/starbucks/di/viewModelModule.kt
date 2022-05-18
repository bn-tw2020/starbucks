package com.example.todo.starbucks.di

import com.example.todo.starbucks.domain.model.Order
import com.example.todo.starbucks.screen.favorite.FavoriteViewModel
import com.example.todo.starbucks.screen.home.events.EventsViewModel
import com.example.todo.starbucks.screen.home.main.HomeViewModel
import com.example.todo.starbucks.screen.home.news.NewsViewModel
import com.example.todo.starbucks.screen.order.detail.DetailViewModel
import com.example.todo.starbucks.screen.order.detailorder.DetailOrderViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { HomeViewModel(get()) }
    viewModel { NewsViewModel(get()) }
    viewModel { EventsViewModel(get()) }
    viewModel { (order: Order) -> DetailViewModel(order, get()) }
    viewModel { (productCD: String) -> DetailOrderViewModel(productCD, get(), get()) }
    viewModel { FavoriteViewModel(get())}
}