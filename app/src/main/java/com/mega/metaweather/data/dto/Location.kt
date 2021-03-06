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
        lowestTemperature = consolidated_weather[0].min_temp.toInt(),
        highestTemperature = consolidated_weather[0].max_temp.toInt(),
        currentTemperature = consolidated_weather[0].the_temp.toInt(),
        weather = consolidated_weather[0].weather_state_name,
        weather_abbr = consolidated_weather[0].weather_state_abbr,
        title = title,
        imageUrl = null
    )
}