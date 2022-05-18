package com.example.todo.starbucks.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {

    single { Dispatchers.IO }
    single { provideMoshi() }
    single { provideMoshiConverterFactory(get()) }
    single { buildOkHttpClient() }

    single(named("HomeRetrofit")) { provideHomeRetrofit(get(), get()) }
    single { provideHomeService(get(named("HomeRetrofit"))) }

    single(named("ProductRetrofit")) { provideProductRetrofit(get(), get()) }
    single { provideProductService(get(named("ProductRetrofit"))) }
}