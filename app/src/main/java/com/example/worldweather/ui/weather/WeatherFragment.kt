package com.example.worldweather.ui.weather

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.worldweather.R
import com.example.worldweather.databinding.WeatherFragmentBinding
import com.example.worldweather.utils.bases.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
@AndroidEntryPoint
class WeatherFragment : BaseFragment<WeatherFragmentBinding,WeatherViewModel>(R.layout.weather_fragment) {

    override val viewModel: WeatherViewModel by viewModels()

    override fun init() {

    }

    override fun observedLiveData() {
        viewModel.weatherResponse.observe(viewLifecycleOwner){
            if(it != null){
                binding.tvCurrentType.text = it.current?.temp.toString()
            }
        }
    }


}