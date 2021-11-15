package com.example.worldweather.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.worldweather.network.datamodel.WeatherRequest
import com.example.worldweather.network.datamodel.WeatherResponse
import com.example.worldweather.network.repositories.iApiRepository
import com.example.worldweather.utils.bases.BaseViewModel
import kotlinx.coroutines.launch

class ShareViewModel : BaseViewModel() {
    private val _hasValue = MutableLiveData(false)
    val hasValue: LiveData<Boolean>
        get() = _hasValue
    val weatherResponse = MutableLiveData<WeatherResponse>()
    fun getWeather(weatherResp: WeatherResponse){
        weatherResponse.value = weatherResp
        _hasValue.postValue(true)
    }

}