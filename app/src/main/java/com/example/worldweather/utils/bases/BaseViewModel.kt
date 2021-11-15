package com.example.worldweather.utils.bases

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.worldweather.utils.TEHRAN_LAT_LNG
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {
    val lat = MutableLiveData<String>()
    val lon = MutableLiveData<String>()
    fun setLatLonTehran(){
        lat.value = TEHRAN_LAT_LNG.latitude.toString()
        lon.value = TEHRAN_LAT_LNG.longitude.toString()
    }
    fun updateLat(newLat: String){
        lat.value = newLat
    }
    fun updateLon(newLon: String){
        lon.value = newLon
    }
}