package com.example.imgurimagesb.data.repository

import com.example.imgurimagesb.data.model.ImageModel
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imagesDataSource: ImagesDataSource
): ImagesRepository {
    override suspend fun fetchImages(): List<ImageModel> {
        return imagesDataSource.fetchImages()
    }
}