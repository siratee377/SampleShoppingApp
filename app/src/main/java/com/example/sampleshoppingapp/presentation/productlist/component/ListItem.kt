package com.example.sampleshoppingapp.presentation.productlist.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.sampleshoppingapp.domain.model.ProductItem
import com.example.sampleshoppingapp.presentation.commonui.UserDescription


@Composable
fun ListItem(item: ProductItem, onItemClick: (ProductItem) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.dp)
                .clickable {
                    onItemClick(item)
                }) {
            Image(
                modifier = Modifier
                    .size(200.dp)
                    .padding(8.dp)
                    .weight(0.4f),
                painter = rememberAsyncImagePainter(item.image),
                contentDescription = ""
            )
            UserDescription(item, Modifier.weight(0.6f))
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp))
    }
}


