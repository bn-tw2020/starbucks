package com.example.todo.starbucks.data

import com.squareup.moshi.Json

// @Json(name="") / @field:Json(name="")
data class Home(
    @Json(name = "display-name")
    val displayName: String,
    @Json(name = "your-recommand")
    val yourProducts: Products,
    @Json(name = "main-event")
    val mainEvent: MainEvent,
    @Json(name = "now-recommand")
    val nowProducts: Products,
)

data class Products(
    @field:Json(name = "products")
    val products: List<String>,
)

data class MainEvent(
    @Json(name = "img_UPLOAD_PATH")
    val imageUploadPath: String,
    @Json(name = "mob_THUM")
    val thumbnail: String,
)