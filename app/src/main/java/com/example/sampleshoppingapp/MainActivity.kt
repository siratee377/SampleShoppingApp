package com.example.sampleshoppingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.sampleshoppingapp.presentation.productlist.ListingScreen
import com.example.sampleshoppingapp.dls.theme.SampleShoppingAppTheme
import com.example.sampleshoppingapp.presentation.productdetail.ProductDetailScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleShoppingAppTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = ListingModel
                ) {
                    composable<ListingModel> {
                        ListingScreen(navController = navController)
                    }
                    composable<ProductDetailModel> {
                        val args = it.toRoute<ProductDetailModel>()
                        ProductDetailScreen(
                            id = args.id
                        )
                    }
                }
            }
        }
    }
}

@Serializable
object ListingModel

@Serializable
data class ProductDetailModel(
    val id: Int
)