package com.example.foodapi.domain.use_case

import com.example.foodapi.common.Resource
import com.example.foodapi.domain.model.product.Product
import com.example.foodapi.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(id: String) : Flow<Resource<Product>>{
        return repository.getProduct(id)
    }
}