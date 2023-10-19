package com.example.imgurimagesb.framework.di

import com.example.imgurimagesb.data.repository.ImageRepositoryImpl
import com.example.imgurimagesb.data.repository.ImagesDataSource
import com.example.imgurimagesb.data.repository.ImagesRepository
import com.example.imgurimagesb.framework.network.RetrofitDataSource
import com.example.imgurimagesb.usecase.FetchImagesUseCase
import com.example.imgurimagesb.usecase.FetchImagesUseCaseImpl
import com.example.imgurimagesb.util.imageloader.ImageLoader
import com.example.imgurimagesb.util.imageloader.ImageLoaderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun bindImageLoader(imageLoader: ImageLoaderImpl) : ImageLoader

    @Binds
    fun bindImageDataSource(imageDataSource: RetrofitDataSource) : ImagesDataSource

    @Binds
    fun bindRepository(imageRepositoryImpl: ImageRepositoryImpl) : ImagesRepository

    @Binds
    fun bindUseCase(fetchImagesUseCaseImpl: FetchImagesUseCaseImpl) : FetchImagesUseCase

}