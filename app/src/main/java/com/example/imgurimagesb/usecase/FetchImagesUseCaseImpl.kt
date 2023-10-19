package com.example.imgurimagesb.usecase

import com.example.imgurimagesb.data.model.ImageModel
import com.example.imgurimagesb.data.repository.ImagesRepository
import com.example.imgurimagesb.usecase.base.ResultStatus
import com.example.imgurimagesb.usecase.base.UseCase
import javax.inject.Inject

class FetchImagesUseCaseImpl @Inject constructor(
    private val imagesRepository: ImagesRepository
): FetchImagesUseCase, UseCase<FetchImagesUseCase.GetImagesParams, List<ImageModel>>() {
    override suspend fun doWork(params: FetchImagesUseCase.GetImagesParams): ResultStatus<List<ImageModel>> {
        val images = imagesRepository.fetchImages(params.authorization)
        return ResultStatus.Success(images)
    }
}