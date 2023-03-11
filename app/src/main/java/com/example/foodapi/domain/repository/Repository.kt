package com.example.foodapi.domain.repository

import com.example.foodapi.common.Resource
import com.example.foodapi.data.remote.dto.categories.CategoriesDto
import com.example.foodapi.domain.model.product.Product
import com.example.foodapi.domain.model.products.Products
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getProducts(): Flow<Resource<List<Products>>>
    fun getCategories(): Flow<Resource<CategoriesDto>>
    fun getProduct(id: String): Flow<Resource<Product>>
}