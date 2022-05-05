package com.mega.metaweather.di

import com.mega.metaweather.api.MetaweatherService
import com.mega.metaweather.data.repository.LocationRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoriesModule {

    @Singleton
    @Provides
    fun provideLocationRepository(api: MetaweatherService): LocationRepositoryImplementation {
        return LocationRepositoryImplementation(api)
    }
}