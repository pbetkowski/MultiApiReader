package com.example.dev.myapplication.services

import com.example.dev.myapplication.model.CurrencyEntity
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface MainService {

//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("http://api.nbp.pl/api/exchangerates/rates/A/USD?format-json")
//    fun getUSD(): Observable<List<WMSClients>>
//
    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET("http://api.nbp.pl/api/exchangerates/rates/A/USD?format-json")
    fun getUSD(): Observable<CurrencyEntity>

    @Headers("Accept: application/json", "Content-Type: application/json")
    @GET("http://api.nbp.pl/api/exchangerates/rates/A/EUR?format-json")
    fun getEUR(): Observable<CurrencyEntity>


    companion object {

        fun initialize() : MainService{

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl("http://api.nbp.pl/api/exchangerates/")
                .build()
            return retrofit.create(MainService::class.java)
        }
    }
}