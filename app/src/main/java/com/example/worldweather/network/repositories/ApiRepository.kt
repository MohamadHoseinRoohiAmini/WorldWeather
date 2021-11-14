package com.example.worldweather.network.repositories

import com.example.worldweather.network.ApiService
import com.example.worldweather.network.datamodel.WeatherRequest
import com.example.worldweather.network.datamodel.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ApiRepository @Inject constructor(private val apiService: ApiService) : iApiRepository {
    override suspend fun getWeather(request: WeatherRequest): WeatherResponse =
        withContext(Dispatchers.IO){
            return@withContext apiService.getWeather(request.latitude.toString(),request.longitude.toString())
        }
}