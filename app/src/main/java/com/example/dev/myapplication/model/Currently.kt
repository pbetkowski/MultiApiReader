package com.example.dev.myapplication.model

data class Currently constructor(
    val time: Float,
    val summary: String,
    val icon: String,
    val precipIntensity: Float,
    val precipProbability: Float,
    val precipType: String,
    val temperature: Float,
    val apparentTemperature: Float,
    val dewPoint: Float,
    val humidity: Float,
    val pressure: Float,
    val windSpeed: Float,
    val windGust: Float,
    val windBearing: Float,
    val cloudCover: Float,
    val uvIndex: Float,
    val visibility: Float,
    val ozone: Float
)