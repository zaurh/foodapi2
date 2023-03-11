package com.example.foodapi.data.mapper

import com.example.foodapi.data.remote.dto.product.ProductDto
import com.example.foodapi.data.remote.dto.products.ProductsDto
import com.example.foodapi.data.remote.dto.products.ProductsListDto
import com.example.foodapi.domain.model.product.Product
import com.example.foodapi.domain.model.products.Products
import com.example.foodapi.domain.model.products.ProductsList

fun ProductsDto.toProducts() = Products(title, brand,description, discountPercentage, id, images, price, rating, stock, thumbnail, title)
fun ProductsListDto.toProductList() = ProductsList(limit, products.map { it.toProducts() }, skip, total)

fun ProductDto.toProduct() = Product(brand, category, description, discountPercentage, id, images, price, rating, stock, thumbnail, title)