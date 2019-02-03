package com.example.dev.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.timer.*
import java.util.*




class TimeIsNigh: Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.timer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val thread = object : Thread() {

            override fun run() {
                try {
                    while (!this.isInterrupted) {
                        Thread.sleep(1000)
                        activity?.runOnUiThread {
//
                            timeText?.text = getDayOfWeek()
                            timeText2?.text = getTime()
                            timeText3?.text = getDate()
                        }
                    }
                } catch (e: InterruptedException) {
                }

            }
        }

        thread.start()

    }

    private fun getDayOfWeek(): String {
        var dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        when (dayOfWeek) {
            1 -> return "Niedziela"
            2 -> return "Poniedziałek"
            3 -> return "Wtorek"
            4 -> return "Środa"
            5 -> return "Czwartek"
            6 -> return "Piątek"
            7 -> return "Sobota"
        }
        return ""
    }

    private fun getTime(): String {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val minutes = Calendar.getInstance().get(Calendar.MINUTE)
        val seconds = Calendar.getInstance().get(Calendar.SECOND)

        return "$hour:$minutes:$seconds"
    }

    private fun getDate(): String {
        val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        val x: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
        val month = x[Calendar.getInstance().get(Calendar.MONTH)]
        val year = Calendar.getInstance().get(Calendar.YEAR)

        if (month<10) {
            return "$day:0$month:$year"
        }

        return "$day:$month:$year"
    }
}