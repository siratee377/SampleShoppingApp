package com.example.sampleshoppingapp.domain.repository

import com.example.sampleshoppingapp.domain.model.ProductItem

interface Repository {

    suspend fun getProductList() : List<ProductItem>

    suspend fun getProductDetail(id : String) : ProductItem

}