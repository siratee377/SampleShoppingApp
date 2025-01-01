package com.example.sampleshoppingapp.presentation.state

import com.example.sampleshoppingapp.domain.model.ProductItem

data class ProductDetailState(
    val isLoading: Boolean = false,
    val data: ProductItem? = null,
    var error: String = ""
)
