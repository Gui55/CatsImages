package com.example.imgurimagesb.framework.network

import com.example.imgurimagesb.BuildConfig
import com.example.imgurimagesb.data.model.ImageModel
import com.example.imgurimagesb.data.repository.ImagesDataSource
import javax.inject.Inject

class RetrofitDataSource @Inject constructor(
    private val imagesApi: ImagesApi
) : ImagesDataSource {
    override suspend fun fetchImages(): List<ImageModel> {
        val response = imagesApi.getImages(BuildConfig.AUTHORIZATION)
        val models: ArrayList<ImageModel> = ArrayList()

        for(ip in response.data){
            for(im in ip.images){
                models.add(im)
            }
        }

        return models
    }
}