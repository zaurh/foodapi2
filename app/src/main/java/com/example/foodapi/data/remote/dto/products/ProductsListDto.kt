package com.example.foodapi.data.remote.dto.products

data class ProductsListDto(
    val limit: Int,
    val products: List<ProductsDto>,
    val skip: Int,
    val total: Int
)