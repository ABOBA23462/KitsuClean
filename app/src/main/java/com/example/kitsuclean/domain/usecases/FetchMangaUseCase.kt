package com.example.kitsuclean.domain.usecases

import com.example.kitsuclean.domain.repositories.MangaRepository
import javax.inject.Inject

class FetchMangaUseCase @Inject constructor(
    private val mangaRepository: MangaRepository
) {

    operator fun invoke() = mangaRepository.fetchManga()
}