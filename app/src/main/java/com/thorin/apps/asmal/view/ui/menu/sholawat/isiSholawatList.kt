package com.thorin.apps.asmal.view.ui.menu.sholawat

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.thorin.apps.asmal.R
import kotlinx.android.synthetic.main.activity_isi_sholawat_list.*

class isiSholawatList : AppCompatActivity() {

    companion object {
        const val EXTRA_NAMA = "EXTRA_NAMA"
        const val EXTRA_ISI = "EXTRA_ISI"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_sholawat_list)

        val sholawatName: TextView = findViewById(R.id.nama_sholawat)
        val sholawatDescrip: TextView = findViewById(R.id.isi_sholawat)

        val nSholawat = intent.getStringExtra(EXTRA_NAMA)
        val nDescrip = intent.getStringExtra(EXTRA_ISI)

        if (supportActionBar != null)
            supportActionBar?.hide()

        sholawatName.text = nSholawat
        sholawatDescrip.text = nDescrip

        seekBarSholawat.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            var p = 0
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
                if (p < 30) {
                    p = 30
                    seekBar.progress = p
                }
            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // TODO Auto-generated method stub
                p = progress
                isi_sholawat.textSize = p.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }
        })

    }
}