package com.example.weatherfetcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.weatherfetcher.feature.weather_screen.data.*
import com.example.weatherfetcher.feature.weather_screen.ui.WeatherScreenPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var presenter : WeatherScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = WeatherScreenPresenter(
            WeatherInteractor(
                WeatherRepoImpl(
                    WeatherRemoteSource(
                        WeatherApiClient().getApi()
                    )
                )
            )
        )
        val textViewManin = findViewById<TextView>(R.id.textViewMain)
        GlobalScope.launch {
            //Log.d("NETD", presenter.interactor.getWeather())
            withContext(Dispatchers.Main){
                textViewManin.text = presenter.interactor.getWeather()
            }


        }
    }
}