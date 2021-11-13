package com.example.worldweather.network

import com.example.worldweather.network.datamodel.WeatherRequest
import com.example.worldweather.network.datamodel.WeatherResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("onecall")
    fun getWeather(@Body request:WeatherRequest ) : WeatherResponse
}