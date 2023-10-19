package com.example.imgurimagesb.usecase

import com.example.imgurimagesb.data.model.ImageModel

interface FetchImagesUseCase {
    suspend fun fetchImages(): List<ImageModel>
}