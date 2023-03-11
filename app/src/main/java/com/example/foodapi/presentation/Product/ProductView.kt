package com.example.foodapi.presentation.Product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.foodapi.presentation.components.BottomBar
import com.example.foodapi.presentation.components.TopBar

@Composable
fun ProductView(
    viewModel: ProductViewModel = hiltViewModel(),
    navController: NavController
) {
    val product = viewModel.state.value.product
    Scaffold(
        topBar = {
            TopBar()
        },
        content = {

            Box(modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = com.example.foodapi.R.color.background))){
                product?.let { it ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,) {
                        Box(modifier = Modifier.height(300.dp)){
                            Image(
                                painter = rememberImagePainter(data = it.thumbnail),
                                contentDescription = "",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Row(
                            Modifier.fillMaxWidth().padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = it.title, fontSize = 30.sp)
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Default.FavoriteBorder,"")
                            }
                        }


                    }
                }
            }


        },
        bottomBar = {
            BottomBar(navController)
        }
    )
}