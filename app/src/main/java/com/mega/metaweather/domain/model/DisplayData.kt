package com.mega.metaweather.domain.model

data class DisplayData(
    val lowestTemperature: Double,
    val highestTemperature: Double,
    val currentTemperature: Double,
    val weather: String,
    val weather_abbr: String,
    val title: String,
    var imageUrl: String?
)