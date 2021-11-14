package com.example.worldweather.network.datamodel

import com.squareup.moshi.Json

data class WeatherRequest (
    @Json(name = "lat")
    var latitude:String?,
    @Json(name = "lon")
    var longitude:String?,
    @Json(name = "appid")
    val appid : String = "c02c53810c03d0d4fcd6d74658d27263"
)