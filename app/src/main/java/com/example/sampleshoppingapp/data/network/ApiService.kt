package com.example.sampleshoppingapp.data.network

import com.example.sampleshoppingapp.data.model.ProductDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("/products")
    suspend fun getAllProductListAPI() : List<ProductDetailResponse>

    @GET("/products/{Id}")
    suspend fun getProductDetailsAPI(@Path("Id") id : String) : ProductDetailResponse

}