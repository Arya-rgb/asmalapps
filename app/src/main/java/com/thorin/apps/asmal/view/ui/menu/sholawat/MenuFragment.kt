package com.thorin.apps.asmal.view.ui.menu.sholawat

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.thorin.apps.asmal.R
import com.thorin.apps.asmal.databinding.FragmentMenuBinding
import com.thorin.apps.asmal.view.ui.menu.ratib.MenuRatibsActivity
import com.thorin.apps.asmal.view.ui.menu.tasbih.TasbihActivity


class MenuFragment : Fragment(R.layout.fragment_menu) {

    private var fragmentMenuBinding: FragmentMenuBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMenuBinding.bind(view)
        fragmentMenuBinding = binding

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
        fragmentMenuBinding = null
        super.onDestroyView()
    }
}
