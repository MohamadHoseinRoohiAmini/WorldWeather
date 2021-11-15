package com.example.worldweather.ui.weather

import android.opengl.Visibility
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.viewModels
import com.example.worldweather.R
import com.example.worldweather.databinding.WeatherFragmentBinding
import com.example.worldweather.ui.ShareViewModel
import com.example.worldweather.utils.bases.BaseFragment
import com.example.worldweather.utils.kelvinToCel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class WeatherFragment : BaseFragment<WeatherFragmentBinding,WeatherViewModel>(R.layout.weather_fragment) {

    override val viewModel: WeatherViewModel by viewModels()
    private lateinit var sharedViewModel:ShareViewModel
    override fun init() {
        sharedViewModel = ViewModelProvider(requireActivity())[ShareViewModel::class.java]
    }

    override fun observedLiveData() {
        sharedViewModel.weatherResponse.observe(viewLifecycleOwner){
            it.apply {
                binding.tvCurrentType.text = this.current?.weather?.first()?.main
                binding.tvCurrentCelsius.text =  Int.kelvinToCel(this.current?.temp).toString() + "C"
                binding.rvDaily.adapter =
                    it?.daily?.toList()?.let { it1 -> WeatherAdapter(it1) }
                binding.apply {
                    fragmentContainerView3.visibility = GONE
                    rvDaily.visibility = VISIBLE
                    fragmentContainerView.visibility = VISIBLE
                    linearLayout.visibility = VISIBLE
                }
            }
        }
    }


}
