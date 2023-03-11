package com.example.foodapi.presentation.Product

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapi.common.Resource
import com.example.foodapi.domain.use_case.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel() {

    private val _state = mutableStateOf(ProductState())
        val state: State<ProductState> = _state


    init {
        savedStateHandle.get<String>("id")?.let { id ->
            getProduct(id)
        }
    }
    private fun getProduct(id: String){
        viewModelScope.launch {
            getProductUseCase(id).collect{ result ->
                when(result){
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            product = result.data
                        )
                    }
                }
            }

        }
    }
}