package com.example.foodapi.domain.use_case

import com.example.foodapi.common.Resource
import com.example.foodapi.domain.model.Recipe
import com.example.foodapi.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(): Flow<Resource<List<Recipe>>> {
        return repository.getRecipes()
    }

}