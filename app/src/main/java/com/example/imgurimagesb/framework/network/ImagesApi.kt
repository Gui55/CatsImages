package com.example.imgurimagesb.framework.network

import com.example.imgurimagesb.BuildConfig
import com.example.imgurimagesb.data.model.ImageResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface ImagesApi {

    @GET(BuildConfig.ENDPOINT)
    suspend fun getImages(
        @Header("Authorization") authorization: String
    ) : ImageResponse

}