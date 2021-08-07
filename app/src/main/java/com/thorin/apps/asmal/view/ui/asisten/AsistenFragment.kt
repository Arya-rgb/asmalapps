package com.thorin.apps.asmal.view.ui.asisten

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.thorin.apps.asmal.R
import com.thorin.apps.asmal.databinding.FragmentAsistenBinding
import com.thorin.apps.asmal.databinding.FragmentDashboardBinding
import com.thorin.apps.asmal.view.ui.asisten.catatamal.CatatAmalActivity

class AsistenFragment : Fragment(R.layout.fragment_asisten) {

    private var _binding: FragmentAsistenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAsistenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        assistantNavigation()

    }

    private fun assistantNavigation() {

        binding.moveCatatAmal.setOnClickListener {
            val moveIntent = Intent(activity, CatatAmalActivity::class.java)
            startActivity(moveIntent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}