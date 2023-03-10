package com.example.foodapi.data.mapper

import com.example.foodapi.data.remote.dto.RecipeDto
import com.example.foodapi.data.remote.dto.RecipeListDto
import com.example.foodapi.domain.model.Recipe
import com.example.foodapi.domain.model.RecipeList

fun RecipeDto.toRecipe() = Recipe(id, image, title, vegan, vegetarian, veryHealthy, veryPopular)
fun RecipeListDto.toRecipeList() = RecipeList(recipes = recipes.map { it.toRecipe() })