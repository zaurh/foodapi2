package com.example.foodapi.data.remote

import com.example.foodapi.data.remote.dto.categories.CategoriesDto
import com.example.foodapi.data.remote.dto.product.ProductDto
import com.example.foodapi.data.remote.dto.products.ProductsListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyApi {
    @GET("products")
    suspend fun getProducts(
        @Query("limit") limit: Int = 100,
    ): ProductsListDto

    @GET("products/{id}")
    suspend fun getProduct(
        @Path("id") id : String
    ): ProductDto

    @GET("products/categories")
    suspend fun getCategories(): CategoriesDto

}