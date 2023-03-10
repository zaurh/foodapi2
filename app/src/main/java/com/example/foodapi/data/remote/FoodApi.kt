package com.example.foodapi.data.remote

import com.example.foodapi.common.Constants.API_KEY
import com.example.foodapi.data.remote.dto.RecipeListDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {
    @GET("recipes/random")
    suspend fun getRecipes(
        @Query("number") number: Int = 10,
        @Query("apiKey") apiKey: String = API_KEY
    ): RecipeListDto

}