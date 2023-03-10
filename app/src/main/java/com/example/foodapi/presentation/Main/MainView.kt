package com.example.foodapi.presentation.Main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.foodapi.presentation.components.CardItem
import com.example.foodapi.presentation.components.SearchView

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainView(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val recipes = mainViewModel.recipe.value.recipes
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = com.example.foodapi.R.color.background))){
        Column(
            Modifier
                .fillMaxSize()
                .padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "Hello Zaur", fontSize = 40.sp)
            SearchView(state = textState)
            if (recipes.isEmpty()){
                Text(text = "List bosdur")
            }else{
                LazyVerticalGrid(cells = GridCells.Fixed(2)){
                    items(recipes){ result ->
                        CardItem(recipe = result)
                    }
                }
            }

        }
    }
}