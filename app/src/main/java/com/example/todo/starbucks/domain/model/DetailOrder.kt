package com.example.todo.starbucks.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_item")
data class DetailOrder(
    @PrimaryKey
    @ColumnInfo(name = "product_cd")
    val productCD: String,
    @ColumnInfo(name = "image_url")
    val imageURL: String,
    val name: String?,
    @ColumnInfo(name = "name_eng")
    val nameENG: String?,
    val description: String?,
    @ColumnInfo(name = "hot_yn")
    val hotYN: String?,
    val kcal: String?,
    val sugars: String?,
    val sodium: String?,
    val protein: String?,
    val caffeine: String?,
    @ColumnInfo(name = "sat_fat")
    val satFAT: String?,
    val allergy: String?,
    var price: Int?,
)