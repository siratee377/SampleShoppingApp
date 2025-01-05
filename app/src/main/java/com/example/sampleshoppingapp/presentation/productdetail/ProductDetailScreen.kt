package com.example.sampleshoppingapp.presentation.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.sampleshoppingapp.presentation.commonui.UserDescription

@Composable
fun ProductDetailScreen(
    viewModel: ProductDetailVewModel = hiltViewModel(),
    id: Int
) {
    val result by viewModel.productDetail.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getProductDetailAPi(id.toString())
    }

    if (result.isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(modifier = Modifier.size(50.dp))
        }
    }

    result.data?.let { data ->
        Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(padding)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = rememberAsyncImagePainter(data.image),
                    contentDescription = ""
                )
                UserDescription(data, Modifier.padding(horizontal = 24.dp))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(5.dp)
            ) {

            }
        }
    }

    if (result.error.isNotEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = result.error)
        }
    }

}