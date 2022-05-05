package com.mega.metaweather.api

import com.mega.metaweather.data.dto.Location
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Path

interface MetaweatherService {

    @POST("api/location/{id}")
    suspend fun getLocationById(@Path("id") id : String): Location

    companion object {
        const val BASE_URL = "https://www.metaweather.com/"
        const val IMAGE_URL = "${BASE_URL}static/img/weather/"

        fun create(): MetaweatherService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MetaweatherService::class.java)
        }
    }
}
