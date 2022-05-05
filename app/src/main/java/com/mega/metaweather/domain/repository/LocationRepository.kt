package com.mega.metaweather.domain.repository

import com.mega.metaweather.data.dto.Location

interface LocationRepository {
    suspend fun getLocationById(id:String): Location
}