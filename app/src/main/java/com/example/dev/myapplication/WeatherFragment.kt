package com.example.dev.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dev.myapplication.presenter.IWeatherPresenter
import kotlinx.android.synthetic.main.timer.*
import kotlinx.android.synthetic.main.weather_fragment.*

class WeatherFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.weather_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val presenter = IWeatherPresenter()
        presenter.getTemperature(temp1, temp2)

        val thread = object : Thread() {

            override fun run() {
                try {
                    while (!this.isInterrupted) {
                        Thread.sleep(1800000)
                        activity?.runOnUiThread {
                            presenter.getTemperature(temp1, temp2)
                        }
                    }
                } catch (e: InterruptedException) {
                }

            }
        }

        thread.start()
    }
}