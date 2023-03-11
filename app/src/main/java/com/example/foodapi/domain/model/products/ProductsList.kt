package com.example.foodapi.domain.model.products

data class ProductsList(
    val limit: Int,
    val products: List<Products>,
    val skip: Int,
    val total: Int
)
