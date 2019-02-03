package com.example.dev.myapplication.services

import com.example.dev.myapplication.model.CurrencyEntity
import com.example.dev.myapplication.model.WeatherEntity
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface WeatherService {


    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET("https://api.darksky.net/forecast/key/49.807621,19.055840")
    fun getTemperature(): Observable<WeatherEntity>

    companion object {

        fun initialize() : WeatherService{

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl("https://api.darksky.net/forecast/")
                .build()
            return retrofit.create(WeatherService::class.java)
        }
    }
}