package com.thorin.apps.ratibsholawatmaulidkitabkuning.ui.menu

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.thorin.apps.ratibsholawatmaulidkitabkuning.R
import kotlinx.android.synthetic.main.sholawat_bait.*

class BaitSholawat : AppCompatActivity() {

    companion object {
        const val EXTRA_NAMA_ARAB = "EXTRA_NAMA_ARAB"
        const val EXTRA_NAMA_LATIN = "EXTRA_NAMA_LATIN"
        const val EXTRA_BAIT = "EXTRA_BAIT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.sholawat_bait)

        val namaArab: TextView = findViewById(R.id.nama_arab)
        val namaLatin: TextView = findViewById(R.id.nama_latin)
        val baitSholawat: TextView = findViewById(R.id.bait_sholawat)

        val nArab = intent.getStringExtra(EXTRA_NAMA_ARAB)
        val nLatin = intent.getStringExtra(EXTRA_NAMA_LATIN)
        val bSholawat = intent.getStringExtra(EXTRA_BAIT)

        namaArab.text = nArab
        namaLatin.text = nLatin
        baitSholawat.text = bSholawat

        seekBarSholawat.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            internal var p = 0
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
                if (p < 30) {
                    p = 30
                    seekBarSholawat.progress = p
                }
            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // TODO Auto-generated method stub
                p = progress
                bait_sholawat.textSize = p.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }
        })
    }
}

