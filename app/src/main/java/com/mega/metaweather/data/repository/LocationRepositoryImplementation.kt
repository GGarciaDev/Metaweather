package com.mega.metaweather.data.repository

import com.mega.metaweather.api.MetaweatherService
import com.mega.metaweather.data.dto.Location
import com.mega.metaweather.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImplementation @Inject constructor(
    private val api: MetaweatherService
): LocationRepository {

    override suspend fun getLocationById(id:String): Location {
        return api.getLocationById(id)
    }

}