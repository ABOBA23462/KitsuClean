package com.example.kitsuclean.di

import com.example.kitsuclean.data.repositories.AnimeRepositoryImpl
import com.example.kitsuclean.data.repositories.MangaRepositoryImpl
import com.example.kitsuclean.domain.repositories.AnimeRepository
import com.example.kitsuclean.domain.repositories.MangaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun provideMangaRepository(repositoryImpl: MangaRepositoryImpl): MangaRepository

    @Binds
    fun provideAnimeRepository(repositoryImpl: AnimeRepositoryImpl): AnimeRepository
}