package com.example.sampleshoppingapp.presentation.state

import com.example.sampleshoppingapp.domain.model.ProductItem

data class ProductListState(
    val isLoading: Boolean = false,
    val data: List<ProductItem>? = null,
    var error: String = ""
)
