package com.mega.metaweather.utilities

import com.mega.metaweather.domain.model.DisplayData

data class LocationStateList(
    val isLoading: Boolean = false,
    val displayData: DisplayData? = null,
    val error: String = ""
)