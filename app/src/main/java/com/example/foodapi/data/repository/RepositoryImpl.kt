package com.example.foodapi.data.repository

import com.example.foodapi.common.Resource
import com.example.foodapi.data.mapper.toRecipe
import com.example.foodapi.data.mapper.toRecipeList
import com.example.foodapi.data.remote.FoodApi
import com.example.foodapi.data.remote.dto.RecipeDto
import com.example.foodapi.data.remote.dto.RecipeListDto
import com.example.foodapi.domain.model.Recipe
import com.example.foodapi.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: FoodApi
): Repository {

    override fun getRecipes(): Flow<Resource<List<Recipe>>> = flow{
        try {
            emit(Resource.Loading())
            val remoteData = api.getRecipes().toRecipeList().recipes
            emit(Resource.Success(remoteData))
        }
        catch (e: Exception){
            emit(Resource.Error(e.message.toString()))
        }
    }
}