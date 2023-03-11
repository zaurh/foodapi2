package com.example.foodapi.presentation.Main

import com.example.foodapi.data.remote.dto.categories.CategoriesDto

data class CategoriesState(
    val categories: CategoriesDto? = null,
    val error: String = "",
    val isLoading: Boolean = false
)
