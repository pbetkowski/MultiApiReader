package com.example.dev.myapplication.presenter

import android.widget.TextView

interface CurrencyPresenter {

    fun getUSD(text: TextView, text2: TextView)
    fun getEUR(text: TextView, text2: TextView)

    interface  CurrencyView {
        fun showError()
        fun showResult()
    }
}