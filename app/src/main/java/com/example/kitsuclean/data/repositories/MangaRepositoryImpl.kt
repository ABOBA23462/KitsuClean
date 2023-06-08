package com.example.kitsuclean.data.repositories

import com.example.kitsuclean.data.base.BaseRepository
import com.example.kitsuclean.data.remote.apiservice.MangaApiService
import com.example.kitsuclean.domain.repositories.MangaRepository
import com.example.kitsueasyclean.data.remote.dtos.toDomain
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MangaRepositoryImpl @Inject constructor(
    private val mangaApiService: MangaApiService
) : BaseRepository(), MangaRepository {

    override fun fetchManga() = doRequest {
        mangaApiService.fetchManga().data.map {
            it.toDomain()
        }
    }
}