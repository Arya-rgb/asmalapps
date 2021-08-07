package com.thorin.apps.asmal.view.ui.dashboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.thorin.apps.asmal.R
import com.thorin.apps.asmal.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance()

        dashboardNavigation()
        loadUserData()

    }

    private fun loadUserData() {

        binding.txtUsername.text = mAuth.currentUser?.displayName
        Glide.with(this)
            .load(mAuth.currentUser?.photoUrl)
            .into(binding.profilPhotoUser)

    }

    private fun dashboardNavigation() {

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

        binding.navProfile.setOnClickListener {
            Intent(activity, ProfileActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}