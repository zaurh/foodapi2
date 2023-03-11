package com.example.foodapi.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable
fun CategoryItem(
    image: String,
    name: String,
//    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.size(120.dp).padding(10.dp)
    ) {

        Image(
            modifier = Modifier.clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Fit,
            painter = rememberImagePainter(data = image),
            contentDescription = "")
        Text(text = name, fontSize = 15.sp)

    }
}