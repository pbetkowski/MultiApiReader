package com.example.dev.myapplication.presenter

import android.widget.TextView
import com.example.dev.myapplication.services.CurrencyService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ICurrencyPresenter(var viewer: CurrencyPresenter.CurrencyView) : CurrencyPresenter {


    private val service = CurrencyService.initialize()

    override fun getUSD(text: TextView, text2: TextView) {
        service.getUSD()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { rate ->
                    text.text = rate.rates[0].mid.toString()
                    viewer.showResult()
                },
                {x -> println(x.message)})
    }

    override fun getEUR(text: TextView, text2: TextView) {
        service.getEUR()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { rate ->
                    text.text = rate.rates[0].mid.toString()
                    viewer.showResult()
                },
                {x -> println(x.message)})
    }
}