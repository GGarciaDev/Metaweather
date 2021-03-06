package com.mega.metaweather.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LocationScreen(
    viewModel: LocationViewModel = hiltViewModel(),
){
    val locationState = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        if(locationState.error.isNotBlank()){
            Text(
                text=locationState.error,
                color= MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .align(Alignment.Center)
            )
        }
        if(locationState.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        locationState.displayData?.let { LocationItem(location = locationState.displayData, Modifier.fillMaxWidth()) }
    }

}