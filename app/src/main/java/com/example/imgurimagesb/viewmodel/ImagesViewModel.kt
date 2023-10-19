package com.example.imgurimagesb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imgurimagesb.BuildConfig
import com.example.imgurimagesb.data.model.ImageModel
import com.example.imgurimagesb.usecase.FetchImagesUseCase
import com.example.imgurimagesb.usecase.base.ResultStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(
    private val fetchImagesUseCase: FetchImagesUseCase
) : ViewModel() {

    private val _images = MutableLiveData<ResultStatus<List<ImageModel>>>()
    val images: LiveData<ResultStatus<List<ImageModel>>> = _images

    fun fetchImages() = viewModelScope.launch {
        fetchImagesUseCase(
            FetchImagesUseCase.GetImagesParams(BuildConfig.AUTHORIZATION)
        ).collect{
            _images.value = it
        }
    }

}