package com.example.imgurimagesb.usecase

import com.example.imgurimagesb.data.model.ImageModel
import com.example.imgurimagesb.usecase.base.ResultStatus
import kotlinx.coroutines.flow.Flow

interface FetchImagesUseCase {
    operator fun invoke(params: GetImagesParams) : Flow<ResultStatus<List<ImageModel>>>
    data class GetImagesParams(val authorization: String)
}