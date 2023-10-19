package com.example.imgurimagesb.usecase

import com.example.imgurimagesb.data.model.ImageModel
import com.example.imgurimagesb.data.repository.ImagesRepository
import javax.inject.Inject

class FetchImagesUseCaseImpl @Inject constructor(
    private val imagesRepository: ImagesRepository
): FetchImagesUseCase {
    override suspend fun fetchImages(): List<ImageModel> {
        return imagesRepository.fetchImages()
    }
}