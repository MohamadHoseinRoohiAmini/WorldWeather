package com.example.worldweather.utils.bases

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.worldweather.network.datamodel.WeatherResponse
import com.example.worldweather.utils.TEHRAN_LAT_LNG
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {
    var lat = MutableLiveData<String>(TEHRAN_LAT_LNG.latitude.toString())
    var lon = MutableLiveData<String>(TEHRAN_LAT_LNG.longitude.toString())
    val weatherResponse = MutableLiveData<WeatherResponse>()

}