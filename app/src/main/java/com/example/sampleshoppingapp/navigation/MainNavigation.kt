package com.example.sampleshoppingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.sampleshoppingapp.presentation.productdetail.ProductDetailScreen
import com.example.sampleshoppingapp.presentation.productlist.ListingScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destination.ListingModel
    ) {
        composable<Destination.ListingModel> {
            ListingScreen(navController = navController)
        }
        composable<Destination.ProductDetailModel> {
            val args = it.toRoute<Destination.ProductDetailModel>()
            ProductDetailScreen(
                id = args.id,
                navController = navController
            )
        }
    }

}