package com.example.sampleshoppingapp.presentation.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.sampleshoppingapp.domain.model.ProductItem
import com.example.sampleshoppingapp.presentation.commonui.UserDescription

@Composable
fun ProductDetailScreen(item: ProductItem) {
    Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(padding)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = rememberAsyncImagePainter(item.image),
                contentDescription = ""
            )
            UserDescription(item, Modifier.padding(horizontal = 24.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.dp)
        ) {

        }
    }
}