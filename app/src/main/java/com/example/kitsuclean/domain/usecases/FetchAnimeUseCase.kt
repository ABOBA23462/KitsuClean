package com.example.kitsuclean.domain.usecases

import com.example.kitsuclean.domain.repositories.AnimeRepository
import javax.inject.Inject

class FetchAnimeUseCase @Inject constructor(
    private val animeRepository: AnimeRepository
) {

    operator fun invoke() = animeRepository.fetchAnime()
}