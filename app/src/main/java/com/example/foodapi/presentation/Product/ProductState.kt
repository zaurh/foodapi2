package com.example.foodapi.presentation.Product

import com.example.foodapi.domain.model.product.Product

data class ProductState(
    val product: Product? = null,
    val error: String = "",
    val isLoading: Boolean = false
)
