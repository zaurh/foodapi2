package com.example.foodapi.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.foodapi.domain.model.products.Products

@Composable
fun CardItem(
    products: Products,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(0.dp))
            .background(colorResource(id = com.example.foodapi.R.color.background))
            .clickable {
                navController.navigate("product/${products.id}")
            }
            .width(200.dp)
            .padding(10.dp)
    ){
        Column(
            Modifier
                .background(colorResource(id = com.example.foodapi.R.color.background))
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ) {

            Image(
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop,
                painter = rememberImagePainter(data = products.thumbnail),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = products.title, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
    }
}