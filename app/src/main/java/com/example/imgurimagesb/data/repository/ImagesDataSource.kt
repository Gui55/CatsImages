package com.example.imgurimagesb.data.repository

import com.example.imgurimagesb.data.model.ImageModel

interface ImagesDataSource {
    suspend fun fetchImages(authorization: String) : List<ImageModel>
}