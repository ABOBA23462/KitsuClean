package com.example.kitsuclean.data.remote.apiservice

import com.example.kitsueasyclean.data.remote.dtos.DataItemDto
import com.example.kitsueasyclean.data.remote.dtos.ResponseDto
import retrofit2.http.GET

interface MangaApiService {

    @GET("edge/manga")
    suspend fun fetchManga(): ResponseDto<DataItemDto>
}