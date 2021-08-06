package com.thorin.apps.asmal.view.ui.menu.sholawat

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.thorin.apps.asmal.R
import com.thorin.apps.asmal.model.ListSholawatData
import com.thorin.apps.asmal.utils.ListSholawatHelper
import kotlinx.android.synthetic.main.activity_sholawat_list.*

class SholawatListActivity : AppCompatActivity() {

    lateinit var adapter: SholawatAsliListAdapter
    lateinit var mAdView : AdView
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sholawat_list)
        val rvRecyclerView = findViewById<RecyclerView>(R.id.recyclerViewSholawatAsli)

        if (supportActionBar != null)
            supportActionBar?.hide()


        mAdView = findViewById(R.id.adView2)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        MobileAds.initialize(this) {}

       MobileAds.setRequestConfiguration(
           RequestConfiguration.Builder()
               .setTestDeviceIds(listOf("B46E966AE01DF822F8A7F5B86DDE8300"))
             .build()
     )



        rvRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        adapter = SholawatAsliListAdapter(this, ListSholawatHelper.getVersionsList())
        rvRecyclerView.adapter = adapter

        sample_editText.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText.toString())
                return true
            }
        })

    }

    public override fun onPause() {
        mAdView.pause()
        super.onPause()
    }

    // Called when returning to the activity
    public override fun onResume() {
        super.onResume()
        mAdView.resume()
    }

    // Called before the activity is destroyed
    public override fun onDestroy() {
        mAdView.destroy()
        super.onDestroy()
    }

    fun filter(text: String) {

        val filteredCourseAry: ArrayList<ListSholawatData> = ArrayList()

        val courseAry: ArrayList<ListSholawatData> = ListSholawatHelper.Companion.getVersionsList()

        for (eachCourse in courseAry) {
            if (eachCourse.sholawatName!!.toLowerCase()
                    .contains(text.toLowerCase()) || eachCourse.sholawatDescrip!!.toLowerCase()
                    .contains(text.toLowerCase())
            ) {
                filteredCourseAry.add(eachCourse)
            }
        }

        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filteredCourseAry)
    }

}