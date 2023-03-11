package com.example.foodapi.presentation.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.foodapi.R

@Composable
fun TopBar() {
    TopAppBar(
        backgroundColor = colorResource(id = R.color.background),
        title = { Text(text = "Products") })
}