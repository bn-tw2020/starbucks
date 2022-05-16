package com.example.todo.starbucks.domain.model

import java.io.Serializable

data class Order(
    val id: String?,
    val imageURL: String?,
    val titleKR: String?,
    val titleENG: String?,
    val price: Int? = null,
) : Serializable {
    companion object {
        fun getRandomPrice(): Int = (3600..6000).random()
    }
}
