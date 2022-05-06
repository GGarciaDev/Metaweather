package com.mega.metaweather.domain.model

data class DisplayData(
    val lowestTemperature: Int,
    val highestTemperature: Int,
    val currentTemperature: Int,
    val weather: String,
    val weather_abbr: String,
    val title: String,
    var imageUrl: String?
)