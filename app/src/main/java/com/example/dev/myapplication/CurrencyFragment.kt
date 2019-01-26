package com.example.dev.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dev.myapplication.presenter.CurrencyPresenter
import com.example.dev.myapplication.presenter.ICurrencyPresenter
import kotlinx.android.synthetic.main.rate_fragment.*

class CurrencyFragment : Fragment(), CurrencyPresenter.CurrencyView{
    override fun showError() {
        println("Błąd")
    }

    override fun showResult() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.rate_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val presenter = ICurrencyPresenter(this)

        presenter.getUSD(l3, l3)
        presenter.getEUR(l4, l4)
    }
}