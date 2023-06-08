package com.example.kitsuclean.presentation.ui.fragments.manga

import androidx.lifecycle.ViewModel
import com.example.kitsuclean.domain.usecases.FetchMangaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val fetchMangaUseCase: FetchMangaUseCase
) : ViewModel() {

    fun fetchManga() = fetchMangaUseCase.invoke()
}