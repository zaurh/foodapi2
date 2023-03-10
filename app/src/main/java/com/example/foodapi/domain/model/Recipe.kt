package com.example.foodapi.domain.model

data class Recipe(
    val id: Int,
    val image: String,
    val title: String,
    val vegan: Boolean,
    val vegetarian: Boolean,
    val veryHealthy: Boolean,
    val veryPopular: Boolean
)
