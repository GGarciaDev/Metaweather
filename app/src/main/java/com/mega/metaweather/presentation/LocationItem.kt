package com.mega.metaweather.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.mega.metaweather.domain.model.DisplayData
import com.mega.metaweather.ui.theme.MetaweatherTheme

@Composable
fun LocationItem(
    location: DisplayData,
    modifier: Modifier? = Modifier
){
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            add(SvgDecoder.Factory())
        }
        .build()
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(30.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(text= location.title,
            style = MaterialTheme.typography.h6,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color= Color.Red
        )
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Image(
                    painter = rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current)
                        .data(data = location.imageUrl).build(), imageLoader = imageLoader),
                    "Weather",
                    modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            Text(text="${location.currentTemperature}º",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                overflow = TextOverflow.Ellipsis)
        }
        Text(text= location.weather,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis)
        Row{
            Text(text = "L: ${location.lowestTemperature}º",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            Text(text = "H: ${location.highestTemperature}º",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MetaweatherTheme {
        LocationItem(DisplayData(
            title = "Toronto",
            currentTemperature = 16,
            weather = "Light Cloud",
            weather_abbr = "LR",
            lowestTemperature = 11,
            highestTemperature = 17,
            imageUrl = "https://www.metaweather.com/static/img/weather/lr.svg"),
        modifier = null)
    }
}