package com.example.kitsuclean.presentation.ui.fragments.anime

import androidx.lifecycle.ViewModel
import com.example.kitsuclean.domain.usecases.FetchAnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val fetchAnimeUseCase: FetchAnimeUseCase
) : ViewModel() {

    fun fetchAnime() = fetchAnimeUseCase.invoke()
}