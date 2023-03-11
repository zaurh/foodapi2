package com.example.foodapi.presentation.Main

import com.example.foodapi.domain.model.products.Products

data class MainState(
    val products: List<Products> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
