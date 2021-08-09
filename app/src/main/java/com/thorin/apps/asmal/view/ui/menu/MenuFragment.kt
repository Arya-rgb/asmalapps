package com.thorin.apps.asmal.view.ui.menu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.thorin.apps.asmal.R
import com.thorin.apps.asmal.databinding.FragmentAsistenBinding
import com.thorin.apps.asmal.databinding.FragmentMenuBinding
import com.thorin.apps.asmal.view.ui.menu.ratib.MenuRatibsActivity
import com.thorin.apps.asmal.view.ui.menu.sholawat.SholawatListActivity
import com.thorin.apps.asmal.view.ui.menu.tasbih.TasbihActivity


class MenuFragment : Fragment(R.layout.fragment_menu) {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth = FirebaseAuth.getInstance()

        binding.txtMenuUsername.text = mAuth.currentUser?.displayName.toString()

        Glide.with(this)
            .load(mAuth.currentUser?.photoUrl)
            .into(binding.imgMenuProfil)

        binding.moveSholawat.setOnClickListener {
            val moveIntent = Intent(activity, SholawatListActivity::class.java)
            startActivity(moveIntent)
        }

        binding.moveRotib.setOnClickListener {
            val moveIntent = Intent(activity, MenuRatibsActivity::class.java)
            startActivity(moveIntent)
        }

        binding.moveTasbih.setOnClickListener {
            val moveIntent = Intent(activity, TasbihActivity::class.java)
            startActivity(moveIntent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
