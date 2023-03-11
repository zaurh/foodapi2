package com.example.foodapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodapi.presentation.Favorites.FavView
import com.example.foodapi.presentation.Main.MainView
import com.example.foodapi.presentation.Product.ProductView
import com.example.foodapi.ui.theme.FoodapiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodapiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navig()
                }
            }
        }
    }
}
@Composable
fun Navig(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main"){
        composable("main"){
            MainView(navController = navController)
        }
        composable("product/{id}"){
            ProductView(navController = navController)
        }
        composable("favorites"){
            FavView(navController = navController)
        }

    }
}