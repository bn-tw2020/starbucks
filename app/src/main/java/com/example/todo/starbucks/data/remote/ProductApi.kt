package com.example.todo.starbucks.data.remote

import com.example.todo.starbucks.data.ProductFile
import com.example.todo.starbucks.data.ProductInformation
import com.example.todo.starbucks.data.dto.Events
import com.example.todo.starbucks.data.dto.NewsDto
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductApi {

    /**
     * @Description_개인추천메뉴_이미지가져오기
     */
    @FormUrlEncoded
    @POST("menu/productFileAjax.do")
    suspend fun getProductsFile(@Field("PRODUCT_CD") productCD: String): ProductFile

    /**
     * @Description_개인추천메뉴_이름가져오기
     */
    @FormUrlEncoded
    @POST("menu/productViewAjax.do")
    suspend fun getProductInformation(@Field("product_cd") productCD: String): ProductInformation

    /**
     * @Description_이벤트종류_가져오기
     */
    @FormUrlEncoded
    @POST("whats_new/getIngList.do")
    suspend fun getEvents(@Field("MENU_CD") menuCD: String = "all"): Events

    /**
     * @Description_New_가져오기
     */
    @GET("whats_new/newsListAjax.do")
    suspend fun getNews(): NewsDto
}