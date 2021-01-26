package com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thorin.apps.ratibsholawatmaulidkitabkuning.R
import com.thorin.apps.ratibsholawatmaulidkitabkuning.model.DataClassSholawat

class SholawatActivity : AppCompatActivity() {
    private lateinit var rvSholawat: RecyclerView
    private var list: ArrayList<DataClassSholawat> = arrayListOf()
   // private var listAdapter = ListSholawatAdapter(list)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_sholawat)
        rvSholawat = findViewById(R.id.recyclerViewSholawat)
        rvSholawat.setHasFixedSize(true)
        showRecyclerList()

    }
    private fun showRecyclerList(){
        rvSholawat.layoutManager = LinearLayoutManager(this)
        val listSholawatAdapter = ListSholawatAdapter(list)
        rvSholawat.adapter = listSholawatAdapter
    }
}