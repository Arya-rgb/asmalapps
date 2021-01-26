package com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.ratib

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.thorin.apps.ratibsholawatmaulidkitabkuning.R

class RatibFragment : Fragment() {

    private lateinit var ratibViewModel: RatibViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        ratibViewModel =
                ViewModelProvider(this).get(RatibViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ratib, container, false)
        ratibViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root


    }
}