package com.example.dev.myapplication.presenter

import android.widget.TextView
import com.example.dev.myapplication.services.WeatherService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class IWeatherPresenter : WeatherPresenter {

    private val service = WeatherService.initialize()

    override fun getTemperature(textView1: TextView, textView2: TextView) {
        service.getTemperature()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { s ->
                    textView1.text = (((s.currently.temperature-32)*5)/9).toInt().toString()
                    textView2.text = s.timezone

                },
                {x -> println(x.message)})
    }
}