package com.example.foodapi.presentation.Main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapi.common.Resource
import com.example.foodapi.domain.use_case.GetCategoriesUseCase
import com.example.foodapi.domain.use_case.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
): ViewModel() {

    private val _products = mutableStateOf(MainState())
        val products: State<MainState> = _products

    private val _categories = mutableStateOf(CategoriesState())
        val categories: State<CategoriesState> = _categories

    init {
        getRecipes()
        getCategories()
    }


    private fun getRecipes(){
        viewModelScope.launch {
            getProductsUseCase().collect{ result ->
                when(result){
                    is Resource.Success -> {
                        _products.value = products.value.copy(
                            products = result.data ?: emptyList()
                        )
                    }
                }
            }
        }
    }

    private fun getCategories(){
        viewModelScope.launch {
            getCategoriesUseCase().collect{ result ->
                when(result){
                    is Resource.Success -> {
                        _categories.value = categories.value.copy(
                            categories = result.data
                        )
                    }
                }
            }
        }
    }
}