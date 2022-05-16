package com.example.todo.starbucks.domain.repository

import com.example.todo.starbucks.data.Home
import com.example.todo.starbucks.data.ProductFile
import com.example.todo.starbucks.data.ProductInformation
import com.example.todo.starbucks.data.dto.DetailDto
import com.example.todo.starbucks.data.dto.Events
import com.example.todo.starbucks.domain.model.NewNotice
import com.example.todo.starbucks.domain.model.Order
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getHome() : Flow<Result<Home>>
    suspend fun getProductsFile(productCd: String) : Result<ProductFile>
    suspend fun getProductInformation(productCd: String) : Result<ProductInformation>
    suspend fun getEvents(): Flow<Result<Events>>
    suspend fun getNews(): Flow<Result<List<NewNotice>>>
    suspend fun getOrders(id: String): Flow<Result<List<Order>>>
}