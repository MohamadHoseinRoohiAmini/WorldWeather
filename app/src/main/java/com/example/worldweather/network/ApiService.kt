package com.example.worldweather.network

import com.example.worldweather.network.datamodel.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("onecall")
    suspend fun getWeather(@Query("lat")lat:String,@Query("lon")lon:String,@Query("appid")appid:String = "c02c53810c03d0d4fcd6d74658d27263") : WeatherResponse
}