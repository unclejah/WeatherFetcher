package com.example.weatherfetcher.feature.weather_screen.data

import retrofit2.Response

class WeatherRemoteSource(private val api: WeatherApi) {
    //TODO
    fun getWeather(): Response<String> {
        return api.getApi(query = "Moscow")
    }
}