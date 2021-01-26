package com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.dashboard

import android.content.Context
import android.content.SharedPreferences

class SharedPref(context: Context) {
    private var mySharedPref: SharedPreferences = context.getSharedPreferences("filename", Context.MODE_PRIVATE)

    // this method will save the nightMode State : True or False
    fun setNightModeState(state:Boolean) {
        val editor = mySharedPref.edit()
        editor.putBoolean("NightMode", state)
        editor.apply()
    }
    // this method will load the Night Mode State
    fun loadNightModeState():Boolean {
        return mySharedPref.getBoolean("NightMode", false)
    }
}