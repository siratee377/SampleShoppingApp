package com.example.sampleshoppingapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleshoppingapp.core.common.UiState
import com.example.sampleshoppingapp.domain.usecase.GetProductListUseCase
import com.example.sampleshoppingapp.presentation.state.ProductListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductListVewModel @Inject constructor(private val productListUseCase: GetProductListUseCase) : ViewModel(){

    private val _productList = MutableStateFlow(ProductListState())
    val productList : StateFlow<ProductListState>
        get() = _productList.asStateFlow()

    init {
        productListUseCase.invoke().onEach {
            when(it){
                is UiState.Loading->{
                    _productList.value = ProductListState(isLoading = true)
                }
                is UiState.Success->{
                    _productList.value = ProductListState(data = it.data)
                }
                is UiState.Error->{
                    _productList.value = ProductListState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}