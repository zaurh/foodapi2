package com.example.foodapi.presentation.Main

import com.example.foodapi.domain.model.Recipe

data class MainState(
    val recipes: List<Recipe> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
