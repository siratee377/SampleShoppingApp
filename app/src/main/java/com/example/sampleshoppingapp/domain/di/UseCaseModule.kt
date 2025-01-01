package com.example.sampleshoppingapp.domain.di

import com.example.sampleshoppingapp.data.repository.RepositoryImpl
import com.example.sampleshoppingapp.domain.usecase.GetProductDetailUseCase
import com.example.sampleshoppingapp.domain.usecase.GetProductListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun productListUseCaseProvider(repositoryImpl: RepositoryImpl) : GetProductListUseCase {
        return GetProductListUseCase(repositoryImpl)
    }

    @Provides
    @Singleton
    fun productDetailUseCaseProvider(repositoryImpl: RepositoryImpl) : GetProductDetailUseCase {
        return GetProductDetailUseCase(repositoryImpl)
    }

}