package com.example.foodapi.domain.model

import com.example.foodapi.data.remote.dto.RecipeDto

data class RecipeList(
    val recipes: List<Recipe>
)