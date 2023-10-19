package com.example.imgurimagesb.data.repository

import com.example.imgurimagesb.data.model.ImageModel

interface ImagesRepository {
    suspend fun fetchImages(): List<ImageModel>
}