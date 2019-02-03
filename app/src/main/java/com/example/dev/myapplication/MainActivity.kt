package com.example.dev.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dev.myapplication.utils.Navigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Navigator.navigate(supportFragmentManager, DashBoardFragment())

    }

    override fun onBackPressed() {
        // todo weryfikacja logowania
        Navigator.navigate(supportFragmentManager, DashBoardFragment())



    }
}
