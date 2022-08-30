package com.example.weatherfetcher.feature.weather_screen.data

import com.example.weatherfetcher.feature.weather_screen.data.model.WeatherRemoteModel
import retrofit2.Response

class WeatherRemoteSource(private val api: WeatherApi) {
    //TODO
   suspend fun getWeather(): WeatherRemoteModel {
        return api.getApi(query = "Moscow")
    }
}