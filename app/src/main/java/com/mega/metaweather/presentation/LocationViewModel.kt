package com.mega.metaweather.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mega.metaweather.domain.use_case.DisplayGetUseCase
import com.mega.metaweather.utilities.Events
import com.mega.metaweather.utilities.LocationStateList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationUseCase : DisplayGetUseCase
) : ViewModel() {

    private val stateLocation = mutableStateOf(LocationStateList())
    val state: State<LocationStateList> = stateLocation

    init {
        getDisplayData()
    }

    private fun getDisplayData() {
        locationUseCase().onEach {
            when (it) {
                is Events.Success -> {
                    stateLocation.value = LocationStateList(displayData = it.data)
                }
                is Events.Loading -> {
                    stateLocation.value = LocationStateList(isLoading = true)
                }
                is Events.Error -> {
                    stateLocation.value = LocationStateList(error = it.message ?: "An Unexpected Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}