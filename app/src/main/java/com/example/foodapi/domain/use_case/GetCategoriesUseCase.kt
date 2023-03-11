package com.example.foodapi.domain.use_case

import com.example.foodapi.common.Resource
import com.example.foodapi.data.remote.dto.categories.CategoriesDto
import com.example.foodapi.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(): Flow<Resource<CategoriesDto>> {
        return repository.getCategories()
    }

}