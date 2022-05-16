package com.example.todo.starbucks.screen.home.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.starbucks.data.ProductFile
import com.example.todo.starbucks.data.ProductInformation
import com.example.todo.starbucks.domain.model.Event
import com.example.todo.starbucks.domain.model.Events
import com.example.todo.starbucks.domain.model.RecommendProduct
import com.example.todo.starbucks.domain.model.RecommendProducts
import com.example.todo.starbucks.domain.repository.HomeRepository
import com.example.todo.starbucks.screen.home.main.events.EventsState
import com.example.todo.starbucks.screen.home.main.mainevent.MainEventState
import com.example.todo.starbucks.screen.home.main.nowrecommend.PopularProductsState
import com.example.todo.starbucks.screen.home.main.yourrecommend.RecommendProductsState
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homeRepository: HomeRepository,
) : ViewModel() {

    private val _recommendProducts =
        MutableStateFlow<RecommendProductsState>(RecommendProductsState.Normal)
    val recommendProducts: StateFlow<RecommendProductsState> = _recommendProducts

    private val _mainEvent = MutableStateFlow<MainEventState>(MainEventState.Normal)
    val mainEvent: StateFlow<MainEventState> = _mainEvent

    private val _events = MutableStateFlow<EventsState>(EventsState.Normal)
    val events: StateFlow<EventsState> = _events

    private val _popularProducts =
        MutableStateFlow<PopularProductsState>(PopularProductsState.Normal)
    val popularProducts: StateFlow<PopularProductsState> = _popularProducts

    private val _error = MutableStateFlow<Boolean>(false)
    val error: StateFlow<Boolean> = _error

    init {
        getHome()
    }

    private fun getHome() = viewModelScope.launch {
        var isFirst = false
        homeRepository.getHome().collect { result ->
            result.onSuccess { home ->

                // TODO 개인 추천 업데이트
                launch {
                    if (isFirst) {
                        cancel()
                    }
                    val products = mutableListOf<RecommendProduct?>()
                    home.yourProducts.products.forEach { productCd ->
                        val productFile = async { getProductFile(productCd) }
                        val productInformation = async { getProductInformation(productCd) }
                        val file = productFile.await()
                        val information = productInformation.await()
                        if (file?.imageFile?.size != 0)
                            products.add(RecommendProduct(
                                name = information?.Information?.productNM.toString(),
                                imageURL = file?.imageFile?.get(0)?.imgUPLOADPATH +
                                        file?.imageFile?.get(0)?.filePATH)
                            )
                    }

                    _recommendProducts.value =
                        RecommendProductsState.GetRecommendProducts(RecommendProducts(home.displayName,
                            products))
                }

                // TODO 메인 이벤트
                launch {
                    if (isFirst) {
                        cancel()
                    }
                    _mainEvent.value = MainEventState.Loading
                    _mainEvent.value =
                        MainEventState.GetMainEvent(home.mainEvent.imageUploadPath + home.mainEvent.thumbnail)
                }

                // TODO 이벤트 업데이트
                launch {
                    if (isFirst) {
                        cancel()
                    }
                    _events.value = EventsState.Loading
                    homeRepository.getEvents().collect { result ->
                        result.onSuccess { events ->
                            val eventList = events.events.map { event ->
                                Event(
                                    event.title.toString(),
                                    event.sbtitleNAME.toString(),
                                    "https://image.istarbucks.co.kr/upload/promotion/${event.mobTHUM}")
                            }
                            _events.value = EventsState.GetEvents(Events(eventList))
                        }
                            .onFailure { _error.value = true }
                    }
                }

                // TODO 실시간 시간단위 메뉴 업데이트
                launch {
                    val products = mutableListOf<RecommendProduct?>()
                    var index = 1
                    home.nowProducts.products.forEach { productCd ->
                        val productFile = async { getProductFile(productCd) }
                        val productInformation = async { getProductInformation(productCd) }
                        val file = productFile.await()
                        val information = productInformation.await()
                        if (file?.imageFile?.size != 0) {
                            products.add(RecommendProduct(
                                index.toString(),
                                information?.Information?.productNM.toString(),
                                file?.imageFile?.get(0)?.imgUPLOADPATH + file?.imageFile?.get(0)?.filePATH)
                            )
                            index += 1
                        }
                    }
                    _popularProducts.value =
                        PopularProductsState.GetPopularProducts(
                            RecommendProducts(
                                System.currentTimeMillis().toString(),
                                products)
                        )
                }
                isFirst = true
            }
                .onFailure { _error.value = true }
        }
    }

    private suspend fun getProductFile(productCd: String): ProductFile? {
        _popularProducts.value = PopularProductsState.Loading
        _recommendProducts.value = RecommendProductsState.Loading
        return homeRepository.getProductsFile(productCd).getOrNull()
    }

    private suspend fun getProductInformation(productCd: String): ProductInformation? {
        _popularProducts.value = PopularProductsState.Loading
        _recommendProducts.value = RecommendProductsState.Loading
        return homeRepository.getProductInformation(productCd).getOrNull()
    }
}