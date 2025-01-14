package com.example.sampleshoppingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sampleshoppingapp.dls.theme.SampleShoppingAppTheme
import com.example.sampleshoppingapp.navigation.MainNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleShoppingAppTheme {
                MainNavigation()
            }
        }
    }
}