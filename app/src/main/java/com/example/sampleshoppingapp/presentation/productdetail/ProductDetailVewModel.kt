package com.example.sampleshoppingapp.presentation.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleshoppingapp.core.common.UiState
import com.example.sampleshoppingapp.domain.usecase.GetProductDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductDetailVewModel @Inject constructor(private val productDetailUseCase: GetProductDetailUseCase) : ViewModel() {

    private val _productDetail = MutableStateFlow(ProductDetailState())
    val productDetail : StateFlow<ProductDetailState>
        get() = _productDetail.asStateFlow()

    fun getProductDetailAPi(id : String){
        productDetailUseCase.invoke(id).onEach {
            when(it){
                is UiState.Loading->{
                    _productDetail.value = ProductDetailState(isLoading = true)
                }
                is UiState.Success->{
                    _productDetail.value = ProductDetailState(data = it.data)
                }
                is UiState.Error->{
                    _productDetail.value = ProductDetailState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}