package com.mega.metaweather.data.dto

import com.mega.metaweather.domain.model.DisplayData

data class Location(
    val consolidated_weather: List<ConsolidatedWeather>,
    val latt_long: String,
    val location_type: String,
    val parent: Parent,
    val sources: List<Source>,
    val sun_rise: String,
    val sun_set: String,
    val time: String,
    val timezone: String,
    val timezone_name: String,
    val title: String,
    val woeid: Int
)

fun Location.toDisplayData():DisplayData{
    return DisplayData(
        lowestTemperature = consolidated_weather[0].min_temp,
        highestTemperature = consolidated_weather[0].max_temp,
        currentTemperature = consolidated_weather[0].the_temp,
        weather = consolidated_weather[0].weather_state_name,
        title = title,
        imageUrl = null
    )
}