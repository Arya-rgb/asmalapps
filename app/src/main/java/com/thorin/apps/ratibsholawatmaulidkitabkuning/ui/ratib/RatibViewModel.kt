package com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.ratib

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RatibViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Ratib Fragment"
    }
    val text: LiveData<String> = _text
}