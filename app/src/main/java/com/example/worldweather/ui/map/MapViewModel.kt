package com.example.worldweather.ui.map

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.worldweather.network.datamodel.WeatherRequest
import com.example.worldweather.network.datamodel.WeatherResponse
import com.example.worldweather.network.repositories.iApiRepository
import com.example.worldweather.utils.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(private val iApiRepository: iApiRepository) : BaseViewModel() {
    val weatherResp = MutableLiveData<WeatherResponse>()

    fun getWeather() {
        viewModelScope.launch {
            try {
                updateWeather(iApiRepository.getWeather(
                    WeatherRequest(lat.value,lon.value)
                ))
            }catch (e: Exception){
                Timber.e("Error msg : $e")
            }
        }
    }
    private fun updateWeather(weatherResponse: WeatherResponse) {
        weatherResp.value = weatherResponse
    }
}