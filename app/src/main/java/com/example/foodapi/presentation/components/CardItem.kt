package com.example.foodapi.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.foodapi.domain.model.Recipe

@Composable
fun CardItem(
    recipe: Recipe
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(0.dp))
            .background(colorResource(id = com.example.foodapi.R.color.background))
            .clickable { }
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
                painter = rememberImagePainter(data = recipe.image),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = recipe.title, maxLines = 1, overflow = TextOverflow.Ellipsis)
        }
    }
}