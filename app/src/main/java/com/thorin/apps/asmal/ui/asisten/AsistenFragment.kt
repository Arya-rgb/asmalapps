package com.thorin.apps.asmal.ui.asisten

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.thorin.apps.asmal.R
import com.thorin.apps.asmal.databinding.FragmentAsistenBinding
import com.thorin.apps.asmal.ui.asisten.catatamal.CatatAmalActivity

class AsistenFragment : Fragment(R.layout.fragment_asisten) {

    private var fragmentAsistenBinding: FragmentAsistenBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = FragmentAsistenBinding.bind(view)
        fragmentAsistenBinding = binding

        binding.moveCatatAmal.setOnClickListener {
            val moveIntent = Intent(activity, CatatAmalActivity::class.java)
            startActivity(moveIntent)
        }
    }
    override fun onDestroyView() {
        fragmentAsistenBinding = null
        super.onDestroyView()
    }
}