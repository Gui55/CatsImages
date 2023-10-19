package com.example.imgurimagesb.framework.di

import com.example.imgurimagesb.BuildConfig
import com.example.imgurimagesb.framework.network.ImagesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ImagesNetworkModule {

    @Provides
    fun provideGsonConverterFactory() : GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory
    ): ImagesApi{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(ImagesApi::class.java)
    }

}