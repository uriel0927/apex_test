package com.example.testapex.di

import com.example.testapex.data.repository.CharactersRepositoryImpl
import com.example.testapex.domain.repository.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindsCharacterRepository(impl : CharactersRepositoryImpl) : CharactersRepository

}