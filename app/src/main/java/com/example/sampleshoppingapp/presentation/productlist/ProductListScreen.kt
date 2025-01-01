package com.example.composepoc.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sampleshoppingapp.presentation.productlist.component.ListItem
import com.example.sampleshoppingapp.presentation.productlist.ProductListVewModel

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ListingScreen (
    viewModel : ProductListVewModel = hiltViewModel()
){
    val context  = LocalContext.current
    val result by viewModel.productList.collectAsState()

    if(result.isLoading){
        Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            CircularProgressIndicator(modifier = Modifier.size(50.dp))
        }
    }

    result.data?.let {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(it){ item->
                    ListItem(item){product->
                        Toast.makeText(context,product.title,Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    if(result.error.isNotEmpty()){
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = result.error.toString())
        }
    }

}