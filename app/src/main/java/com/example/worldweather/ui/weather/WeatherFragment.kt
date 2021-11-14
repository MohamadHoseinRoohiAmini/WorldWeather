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
import com.example.worldweather.ui.ShareViewModel
import com.example.worldweather.utils.bases.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.wait
import timber.log.Timber
@AndroidEntryPoint
class WeatherFragment : BaseFragment<WeatherFragmentBinding,WeatherViewModel>(R.layout.weather_fragment) {

    override val viewModel: WeatherViewModel by viewModels()
    lateinit var sharedViewModel:ShareViewModel
    override fun init() {
        sharedViewModel = ViewModelProvider(requireActivity()).get(ShareViewModel::class.java)
    }

    override fun observedLiveData() {
        sharedViewModel.weatherResponse.observe(viewLifecycleOwner){
            it.apply {
                binding.tvCurrentType.text = this.current?.weather?.first()?.main
                binding.tvCurrentCelsius.text =  this.current?.temp.toString()
                binding.rvDaily.adapter =
                    it?.daily?.toList()?.let { it1 -> WeatherAdapter(it1,requireContext()) }
            }
        }
    }


}