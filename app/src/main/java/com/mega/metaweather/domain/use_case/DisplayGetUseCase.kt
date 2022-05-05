package com.mega.metaweather.domain.use_case

import com.mega.metaweather.data.dto.toDisplayData
import com.mega.metaweather.domain.model.DisplayData
import com.mega.metaweather.domain.repository.LocationRepository
import com.mega.metaweather.utilities.Events
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DisplayGetUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    operator fun invoke() : Flow<Events<DisplayData>> = flow{
        try{
            emit(Events.Loading<DisplayData>())
            val displayData = repository.getLocationById("").toDisplayData()
            emit(Events.Success<DisplayData>(displayData))
        }
        catch (e: HttpException){
            emit(Events.Error<DisplayData>(message = e.localizedMessage?:"An Unexpected Error Occurred"))
        }
        catch (e: IOException){
            emit(Events.Error<DisplayData>(message = "Could not reach the server due to Internet Connection Loss"))
        }
    }
}