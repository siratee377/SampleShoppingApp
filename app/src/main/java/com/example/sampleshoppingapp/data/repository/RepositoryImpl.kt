package com.example.sampleshoppingapp.data.repository

import com.example.sampleshoppingapp.data.network.ApiService
import com.example.sampleshoppingapp.domain.mapper.toProductItem
import com.example.sampleshoppingapp.domain.model.ProductItem
import com.example.sampleshoppingapp.domain.repository.Repository
import javax.inject.Inject


class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {

    override suspend fun getProductList(): List<ProductItem> {
       return apiService.getAllProductListAPI().map { it.toProductItem() }
    }

    override suspend fun getProductDetail(id: String): ProductItem {
        return apiService.getProductDetailsAPI(id).toProductItem()
    }
}