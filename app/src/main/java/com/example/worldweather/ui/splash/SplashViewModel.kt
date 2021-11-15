package com.example.worldweather.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.worldweather.utils.bases.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel  @Inject constructor()  : BaseViewModel() {
//    private val _isTimerFinished = MutableLiveData(false)
//    val isTimerFinished: MutableLiveData<Boolean>
//        get() = _isTimerFinished
//
//    init {
//        waitOpenApp()
//    }
//
//    private fun waitOpenApp() {
//        viewModelScope.launch {
//            delay(5000)
//            _isTimerFinished.postValue(true)
//        }
//    }
}