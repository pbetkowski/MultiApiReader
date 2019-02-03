package com.example.dev.myapplication.model

data class WeatherEntity constructor(
    val latitude: Float,
    val longitude: Float,
    val timezone: String,
    val currently: Currently

)
