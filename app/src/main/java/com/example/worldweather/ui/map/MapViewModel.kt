package com.example.worldweather.ui.map

import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldweather.network.datamodel.WeatherRequest
import com.example.worldweather.network.repositories.iApiRepository
import com.example.worldweather.utils.REQUEST_LOCATION_PERMISSION
import com.example.worldweather.utils.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(val iApiRepository: iApiRepository) : BaseViewModel() {
    fun getWeather() {
        viewModelScope.launch {
            try {
                weatherResponse.value = iApiRepository.getWeather(
                    WeatherRequest(lat.value,lon.value)
                )
                Timber.i("resulllllllllt : ${weatherResponse.value?.timezone}")
            }catch (e: Exception){
                Timber.e("Erroooooor msg : $e")
            }
        }
    }
}