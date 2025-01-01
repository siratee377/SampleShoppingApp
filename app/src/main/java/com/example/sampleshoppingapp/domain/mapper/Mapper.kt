package com.example.sampleshoppingapp.domain.mapper

import com.example.sampleshoppingapp.data.model.ProductDetailResponse
import com.example.sampleshoppingapp.domain.model.ProductItem

fun ProductDetailResponse.toProductItem() : ProductItem {
    return ProductItem(category= this.category,
        description = this.description,
        id = this.id,
        image= this.image,
        price = this.price,
        title = this.title
    )
}


