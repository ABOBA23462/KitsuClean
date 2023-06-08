package com.example.kitsuclean.data.repositories

import com.example.kitsuclean.data.base.BaseRepository
import com.example.kitsuclean.data.remote.apiservice.AnimeApiService
import com.example.kitsuclean.domain.repositories.AnimeRepository
import com.example.kitsueasyclean.data.remote.dtos.toDomain
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimeRepositoryImpl @Inject constructor(
    private val animeApiService: AnimeApiService
) : BaseRepository(), AnimeRepository {

    override fun fetchAnime() = doRequest {
        animeApiService.fetchAnime().data.map {
            it.toDomain()
        }
    }
}