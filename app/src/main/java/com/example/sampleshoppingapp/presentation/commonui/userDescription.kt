package com.example.sampleshoppingapp.presentation.commonui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleshoppingapp.domain.model.ProductItem

@Composable
fun UserDescription(category: ProductItem, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(category.title, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Text(category.description, fontSize = 12.sp, maxLines = 4, overflow = TextOverflow.Ellipsis)
    }
}