package com.example.foodapi.presentation.Main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.foodapi.presentation.components.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainView(
    mainViewModel: MainViewModel = hiltViewModel(),
    navController: NavController
) {
    val products = mainViewModel.products.value.products
    val categories = mainViewModel.categories.value.categories
    val textState = remember { mutableStateOf(TextFieldValue("")) }


    Scaffold(
        topBar = {
                 TopBar()
        },
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = com.example.foodapi.R.color.background))){
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(5.dp)) {

                    LazyRow{
                        item {
                            categories?.let { result ->
                                for (i in result){
                                    when(i){
                                        "smartphones" -> {
                                            CategoryItem(
                                                image = "https://i.hizliresim.com/f9u4oyg.png",
                                                name = "Smartphones"
                                            )
                                        }
                                        "laptops" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "fragrances" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "skincare" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "groceries" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "home-decoration" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "furniture" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "tops" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "womens-dresses" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "womens-shoes" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "mens-shirts" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "mens-shoes" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "mens-watches" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "womens-watches" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "womens-bags" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "womens-jewellery" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "sunglasses" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "automotive" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "motorcycle" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }
                                        "lighting" -> {
                                            CategoryItem(image = "https://i.hizliresim.com/jf1aswi.png", name = "Laptops")
                                        }


                                    }

                                }
                            }
                        }
                    }

                    SearchView(state = textState)

                    if (products.isEmpty()){
                        Text(text = "List bosdur")
                    }else{
                        LazyVerticalGrid(cells = GridCells.Fixed(2)){
                            items(products){ result ->
                                CardItem(products = result, navController)
                            }
                        }
                    }

                }
        }
        }, bottomBar = {
            BottomBar(navController)
        }
    )
}