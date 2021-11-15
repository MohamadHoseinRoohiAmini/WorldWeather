package com.example.worldweather.utils

fun Int.Companion.kelvinToCel(degrees: Double?) : Int{
    return if(degrees != null) (degrees - 273.15).toInt()
    else 0
}
