package com.example.foodapi.presentation.Main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapi.common.Resource
import com.example.foodapi.domain.use_case.GetRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase
): ViewModel() {

    private val _recipe = mutableStateOf(MainState())
        val recipe: State<MainState> = _recipe

    init {
        getRecipes()
    }


    private fun getRecipes(){
        viewModelScope.launch {
            getRecipesUseCase().collect{ result ->
                when(result){
                    is Resource.Success -> {
                        _recipe.value = recipe.value.copy(
                            recipes = result.data ?: emptyList()
                        )
                    }
                }
            }
        }

    }
}