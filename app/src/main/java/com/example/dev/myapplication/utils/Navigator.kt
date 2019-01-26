package com.example.dev.myapplication.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.example.dev.myapplication.R

object Navigator {


    fun navigate(fragmentManager: FragmentManager?, fragment: Fragment) {
        val transaction = fragmentManager?.beginTransaction()

        transaction?.replace(R.id.container, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }


    //fragments

    fun replaceFragment(fragmentManager: FragmentManager?, fragment: Fragment) {
        fragmentManager?.beginTransaction()?.replace(R.id.container, fragment)?.commit()
    }
}