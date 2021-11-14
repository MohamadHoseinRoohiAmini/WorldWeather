package com.example.worldweather.ui.weather

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.worldweather.R
import com.example.worldweather.databinding.ItemDailyBinding
import com.example.worldweather.network.datamodel.Daily
import java.util.zip.Inflater

class WeatherAdapter(private val dailyList: List<Daily>, private val context: Context) :
    RecyclerView.Adapter<WeatherAdapter.weatherViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): weatherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDailyBinding.inflate(inflater, parent, false)
        return weatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: weatherViewHolder, position: Int) {
        val item = dailyList[position]
        holder.binding.let {
            when (item.weather?.first()?.main) {
                "Clouds" -> it.imgType.setImageResource(R.drawable.cloudy)
                "Clear" -> it.imgType.setImageResource(R.drawable.sunny)
                "Rain" -> it.imgType.setImageResource(R.drawable.rainy)
                "Snow" -> it.imgType.setImageResource(R.drawable.snowy)
                "Haze" -> it.imgType.setImageResource(R.drawable.windy)
                else -> it.imgType.setImageResource(R.drawable.sunny)
            }
            it.tvType.text = item.weather?.first()?.main
            it.tvCelsius.text = item.temp?.day.toString()
            it.tvDate.text = item.dt.toString()
        }

    }

    override fun getItemCount(): Int {
        return dailyList.count()
    }

    class weatherViewHolder(val binding: ItemDailyBinding) : RecyclerView.ViewHolder(binding.root)

}