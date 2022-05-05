package com.mega.metaweather.di

import com.mega.metaweather.api.MetaweatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideMetaweatherService(): MetaweatherService {
        return MetaweatherService.create()
    }
}
