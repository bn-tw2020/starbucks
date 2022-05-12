package com.example.todo.starbucks.di

import com.example.todo.starbucks.data.remote.HomeApi
import com.example.todo.starbucks.data.remote.ProductApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


private const val BASE_URL = "https://api.codesquad.kr/"
private const val PRODUCT_BASE_URL = "https://www.starbucks.co.kr/"

fun buildOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}

fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}

fun provideHomeRetrofit(
    okHttpClient: OkHttpClient,
    moshiConverterFactory: MoshiConverterFactory,
): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(moshiConverterFactory)
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
}

fun provideProductRetrofit(
    okHttpClient: OkHttpClient,
    moshiConverterFactory: MoshiConverterFactory,
): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(moshiConverterFactory)
        .baseUrl(PRODUCT_BASE_URL)
        .client(okHttpClient)
        .build()
}

fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory {
    return MoshiConverterFactory.create(moshi)
}

fun provideHomeService(retrofit: Retrofit): HomeApi {
    return retrofit.create(HomeApi::class.java)
}

fun provideProductService(retrofit: Retrofit): ProductApi {
    return retrofit.create(ProductApi::class.java)
}