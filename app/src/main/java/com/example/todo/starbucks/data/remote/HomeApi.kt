package com.example.todo.starbucks.data.remote

import com.example.todo.starbucks.data.Home
import retrofit2.http.GET

interface HomeApi {

    @GET("starbuckst/")
    suspend fun getHome(): Home
}