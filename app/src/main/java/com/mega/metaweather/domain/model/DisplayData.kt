package com.mega.metaweather.domain.model

data class DisplayData(
    val lowestTemperature: Double?,
    val highestTemperature: Double?,
    val currentTemperature: Double?,
    val weather: String,
    val title: String,
    val imageUrl: String?
)