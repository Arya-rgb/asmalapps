package com.thorin.apps.asmal.view.ui.dashboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.thorin.apps.asmal.R
import com.thorin.apps.asmal.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private var fragmentDashboardBinding: FragmentDashboardBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = FragmentDashboardBinding.bind(view)
        fragmentDashboardBinding = binding

        binding.moveQuran.setOnClickListener {
            val moveIntent = Intent(activity, QuranActivityOnline::class.java)
            startActivity(moveIntent)
        }

        binding.moveMasjid.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=Masjid")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        binding.moveNotif.setOnClickListener {
            val moveIntent = Intent(activity, NotifActivity::class.java)
            startActivity(moveIntent)
        }

        binding.moveSetting.setOnClickListener {
            val moveIntent = Intent(activity, SettingActivity::class.java)
            startActivity(moveIntent)
        }

        binding.moveAbout.setOnClickListener {
            val moveIntent = Intent(activity, AboutThorin::class.java)
            startActivity(moveIntent)
        }

    }
    override fun onDestroyView() {
        fragmentDashboardBinding = null
        super.onDestroyView()
    }

}