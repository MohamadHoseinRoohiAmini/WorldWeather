package com.example.worldweather.network.repositories

import com.example.worldweather.network.datamodel.WeatherRequest
import com.example.worldweather.network.datamodel.WeatherResponse

interface iApiRepository {
    suspend fun getWeather(request:WeatherRequest) : WeatherResponse
}