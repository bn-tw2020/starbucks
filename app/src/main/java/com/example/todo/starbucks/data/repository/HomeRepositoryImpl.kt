package com.example.todo.starbucks.data.repository

import com.example.todo.starbucks.data.Home
import com.example.todo.starbucks.data.ProductFile
import com.example.todo.starbucks.data.ProductInformation
import com.example.todo.starbucks.data.dto.Events
import com.example.todo.starbucks.data.remote.HomeApi
import com.example.todo.starbucks.data.remote.ProductApi
import com.example.todo.starbucks.domain.model.DetailOrder
import com.example.todo.starbucks.domain.model.NewNotice
import com.example.todo.starbucks.domain.model.Order
import com.example.todo.starbucks.domain.repository.HomeRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeRepositoryImpl(
    private val api: HomeApi,
    private val productApi: ProductApi,
) : HomeRepository {

    override suspend fun getHome(): Flow<Result<Home>> = flow {
        var isRunning = false
        while (true) {
            if (isRunning) delay(3600000L)
            emit(runCatching { api.getHome() })
            isRunning = true
        }
    }

    override suspend fun getProductsFile(productCd: String): Result<ProductFile> {
        return runCatching { productApi.getProductsFile(productCd) }
    }

    override suspend fun getProductInformation(productCd: String): Result<ProductInformation> {
        return runCatching { productApi.getProductInformation(productCd) }
    }

    override suspend fun getEvents(): Flow<Result<Events>> = flow {
        emit(runCatching { productApi.getEvents() })
    }

    override suspend fun getNews(): Flow<Result<List<NewNotice>>> = flow {
        emit(
            runCatching {
                val map = productApi.getNews().news.map { new ->
                    NewNotice(
                        new.title.toString(),
                        new.newsDt.toString(),
                        "https://image.istarbucks.co.kr/upload/news/${new.appThnlImgName}")
                }
                map
            }
        )
    }

    override suspend fun getOrders(id: String): Flow<Result<List<Order>>> = flow {
        emit(runCatching {
            productApi.getOrders(id).details.map { detail ->
                val order = Order(
                    detail.productCD,
                    detail.imgUPLOADPATH + detail.filePATH,
                    detail.productNM,
                    detail.productENGNM,
                    Order.getRandomPrice()
                )
                order
            }
        })
    }
}