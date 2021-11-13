package com.example.worldweather.di

import com.example.worldweather.network.repositories.ApiRepository
import com.example.worldweather.network.repositories.iApiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideApiRepository(apiRepository: ApiRepository) : iApiRepository
}