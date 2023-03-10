package com.example.foodapi.domain.repository

import com.example.foodapi.common.Resource
import com.example.foodapi.data.remote.dto.RecipeDto
import com.example.foodapi.data.remote.dto.RecipeListDto
import com.example.foodapi.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getRecipes(): Flow<Resource<List<Recipe>>>
}