package com.example.foodapi.data.repository

import com.example.foodapi.common.Resource
import com.example.foodapi.data.mapper.toProduct
import com.example.foodapi.data.mapper.toProducts
import com.example.foodapi.data.remote.DummyApi
import com.example.foodapi.data.remote.dto.categories.CategoriesDto
import com.example.foodapi.domain.model.product.Product
import com.example.foodapi.domain.model.products.Products
import com.example.foodapi.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: DummyApi
): Repository {

    override fun getProducts(): Flow<Resource<List<Products>>> = flow{
        try {
            emit(Resource.Loading())
            val remoteData = api.getProducts().products.map { it.toProducts() }
            emit(Resource.Success(remoteData))
        }
        catch (e: Exception){
            emit(Resource.Error(e.message.toString()))
        }
    }

    override fun getCategories(): Flow<Resource<CategoriesDto>> = flow{
        try {
            emit(Resource.Loading())
            val remoteData = api.getCategories()
            emit(Resource.Success(remoteData))
        }
        catch (e: Exception){
            emit(Resource.Error(e.message.toString()))
        }
    }

    override fun getProduct(id: String): Flow<Resource<Product>> = flow{
        try {
            emit(Resource.Loading())
            val remoteData = api.getProduct(id).toProduct()
            emit(Resource.Success(remoteData))
        }
        catch (e: Exception){
            emit(Resource.Error(e.message.toString()))
        }
    }
}