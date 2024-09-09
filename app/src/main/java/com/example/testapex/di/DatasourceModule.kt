package com.example.testapex.di

import com.example.testapex.data.datasource.remote.RemoteCharactersDatasource
import com.example.testapex.data.datasource.remote.RemoteCharactersDatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatasourceModule {

    @Singleton
    @Binds
    fun bindsRemoteCharactersDatasource(impl: RemoteCharactersDatasourceImpl): RemoteCharactersDatasource


}