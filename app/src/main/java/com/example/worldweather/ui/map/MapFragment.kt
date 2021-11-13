package com.example.worldweather.ui.map

import android.Manifest
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.worldweather.R
import com.example.worldweather.databinding.MapFragmentBinding
import com.example.worldweather.utils.REQUEST_LOCATION_PERMISSION
import com.example.worldweather.utils.TEHRAN_LAT_LNG
import com.example.worldweather.utils.bases.BaseFragment
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MapFragment : BaseFragment<MapFragmentBinding, MapViewModel>(R.layout.map_fragment) {

    private lateinit var map: GoogleMap
    override val viewModel: MapViewModel by viewModels()



    override fun init() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { map ->
            this.map = map
            enableMyLocation()
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(TEHRAN_LAT_LNG, 11.5F))
            map.uiSettings.setAllGesturesEnabled(true)
            map.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    requireContext(),
                    R.raw.beauty_map
                )
            )
            map.setOnCameraIdleListener {
                val centerLocation = map.cameraPosition.target
                viewModel.lat.observe(viewLifecycleOwner, Observer {
                    centerLocation.latitude
                })
                viewModel.lon.observe(viewLifecycleOwner,{
                    centerLocation.longitude
                })
            }
            viewModel.getWeather()
        }



    }


    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                enableMyLocation()
            }
        }
    }

    private fun enableMyLocation() {
        if (isPermissionGranted()) {
            map.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }
}

