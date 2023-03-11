package com.example.foodapi.presentation.Favorites

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.foodapi.presentation.components.BottomBar
import com.example.foodapi.presentation.components.TopBar

@Composable
fun FavView(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopBar()
        },
        content = {
            Box(modifier = Modifier.fillMaxSize()){
                Text(text = "FavView")
            }
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    )
}