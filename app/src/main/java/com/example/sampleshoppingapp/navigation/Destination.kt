package com.example.sampleshoppingapp.navigation

import kotlinx.serialization.Serializable

sealed class Destination{

    @Serializable
    data object ListingModel

    @Serializable
    data class ProductDetailModel(
        val id: Int
    )

}