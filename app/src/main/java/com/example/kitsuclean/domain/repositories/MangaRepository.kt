package com.example.kitsuclean.domain.repositories

import com.example.kitsuclean.domain.utils.Resource
import com.example.kitsueasyclean.domain.models.DataItem
import kotlinx.coroutines.flow.Flow

interface MangaRepository {

    fun fetchManga(): Flow<Resource<List<DataItem>>>
}