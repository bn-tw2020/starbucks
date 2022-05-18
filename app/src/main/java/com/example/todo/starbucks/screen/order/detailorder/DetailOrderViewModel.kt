package com.example.todo.starbucks.screen.order.detailorder

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.starbucks.data.ProductFile
import com.example.todo.starbucks.data.ProductInformation
import com.example.todo.starbucks.domain.model.DetailOrder
import com.example.todo.starbucks.domain.repository.FavoriteRepository
import com.example.todo.starbucks.domain.repository.HomeRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailOrderViewModel(
    productCD: String,
    private val homeRepository: HomeRepository,
    private val favoriteRepository: FavoriteRepository,
) : ViewModel() {

    private val _detail = MutableStateFlow<DetailOrderState>(DetailOrderState.Normal)
    val detail: StateFlow<DetailOrderState> = _detail

    private val _addEvent = MutableSharedFlow<Unit>(replay = 0)
    val addEvent = _addEvent.asSharedFlow()

    private val _items = MutableStateFlow<Boolean>(false)
    val items = _items.asStateFlow()

    val isFavorite: StateFlow<Boolean> = favoriteRepository.getFavoriteExist(productCD)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    init {
//        setting()
        getDetail(productCD)
    }

    private fun setting() = viewModelScope.launch { favoriteRepository.removeAll() }


    fun getDetail(productCD: String) {
        _detail.value = DetailOrderState.Loading
        viewModelScope.launch {
            launch {
                val productFile = getProductFile(productCD)
                if (productFile == null) _detail.value = DetailOrderState.ERROR
                else {
                    val file = productFile.imageFile?.get(0)
                    val imageURL = file?.imgUPLOADPATH + file?.filePATH
                    val productInformation = getProductInformation(productCD)
                    val product = productInformation?.Information
                    if (productInformation == null) _detail.value = DetailOrderState.ERROR
                    else {
                        val detailOrder = DetailOrder(
                            productCD,
                            imageURL,
                            product?.productNM,
                            product?.productENGNM,
                            product?.recommend,
                            product?.hotYN,
                            product?.kcal + "kcal",
                            product?.sugars + "g",
                            product?.sodium + "mg",
                            product?.protein + "g",
                            product?.caffeine + "mg",
                            product?.satFAT + "g",
                            product?.allergy?.split("@")?.joinToString(" "),
                            null
                        )
                        _detail.value = DetailOrderState.GetDetail(detailOrder)
                    }
                }
            }

        }
    }

    fun toggleFavoriteButton(detailOrder: DetailOrder) {
        viewModelScope.launch {
            if(isFavorite.value) {
                favoriteRepository.removeFavoriteItem(detailOrder)
            }
            else {
                favoriteRepository.addFavoriteItem(detailOrder)
            }
        }
    }

    private suspend fun getProductFile(productCd: String): ProductFile? {
        return homeRepository.getProductsFile(productCd).getOrNull()
    }

    private suspend fun getProductInformation(productCd: String): ProductInformation? {
        return homeRepository.getProductInformation(productCd).getOrNull()
    }
}