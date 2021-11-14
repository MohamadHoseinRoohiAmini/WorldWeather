package com.example.worldweather.ui

import androidx.lifecycle.MutableLiveData
import com.example.worldweather.network.datamodel.WeatherResponse
import com.example.worldweather.utils.bases.BaseViewModel

class ShareViewModel : BaseViewModel() {
    val weatherResponse = MutableLiveData<WeatherResponse>()

    fun getWeather(weatherResp: WeatherResponse){
        weatherResponse.value = weatherResp
    }
}