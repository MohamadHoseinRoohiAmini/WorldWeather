package com.example.worldweather.ui.splash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.worldweather.R
import com.example.worldweather.databinding.SplashFragmentBinding
import com.example.worldweather.ui.ShareViewModel
import com.example.worldweather.utils.bases.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashFragmentBinding,SplashViewModel>(R.layout.splash_fragment) {

//    private lateinit var sharedViewModel: ShareViewModel
    override val viewModel: SplashViewModel by viewModels()
    override fun init() {
/*
        sharedViewModel = ViewModelProvider(requireActivity())[ShareViewModel::class.java]
*/
    }

/*    override fun observedLiveData() {
        viewModel.isTimerFinished.observe(viewLifecycleOwner){
            if(it) findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToWeatherFragment())
        }
    }*/


}