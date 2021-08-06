package com.thorin.apps.asmal.view.ui.menu.ratib

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.thorin.apps.asmal.R
import kotlinx.android.synthetic.main.activity_ratib_hadad_history.*

class RatibHadadHistory : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratib_hadad_history)
        supportActionBar?.hide()

        text_hadad_history.text = """
            Ratib al Haddad diambil dari nama penyusunnya, yakni al Habib Abdullah bin Alwi bin Muhammad al Haddad (1055-1132 H.). Dari beberapa doa-doa dan dzikir-dzikir yang beliau susun, Ratib al Haddad inilah yang paling terkenal dan masyhur. Ratib al Haddad disusun berdasarkan inspirasi, pada malam lailatul Qodar 27 Ramadan 1071 H.
            
            Ratib al Haddad disusun untuk memenuhi permintaan seorang murid beliau bernama Amir dari keluarga Bani Sa’ad yang tinggal di Syibam, salah satu perkampungan di Hadramaut, Yaman. Tujuan Amir meminta Habib Abdullah untuk mengarang Ratib, Agar diadakan suatu wirid dan dzikir di kampungnya, agar mereka dapat mempertahankan dan menyelamatkann diri dari ajaran sesat yang sedang melanda Hadramaut ketika itu.
            
            Pertama-tama, Ratib ini hanya dibaca di kampung Amir sendiri, yaitu Kota Syibam setelah mendapat izin dan ijazah dari al Habib Abdullah bin Alwi al Haddad sendiri. Selepas itu, Ratib ini pun dibaca di Masjid al Hawi milik beliau yang berada di kota Tarim. Biasanya Ratib ini dibaca secara berjamaah setelah shalat ‘isya’.
            
            Pada bulan Ramadan, ratib ini dibaca sebelum shalat Isya untuk mengisi kesempitan waktu menunaikan shalat Tarawih. Ini adalah waktu yang telah ditentukan oleh al Habib Abdullah bin Alwi al Haddad untuk daerah-daerah yang mengamalkan Ratib ini. Biidznillah, daerah-daerah yang mengamalkan ratib ini selamat dan tidak terpengaruh dari kesesatan tersebut.
            
            Setelah al Habib Abdullah bin Alwi Al-Haddad berangkat menunaikan ibadah Haji, Ratib al Haddad mulai dibaca di Mekkah dan Madinah. Al Habib Ahmad bin Zain al Habsyi berkata, “Barang siapa yang membaca Ratib al Haddad dengan penuh keyakinan dan iman, ia akan mendapat sesuatu yang di luar dugaannya”.
            
            Setiap ayat, doa, dan nama Allah yang disebutkan di dalam ratib ini diambil dari bacaan Al Quran dan Hadis Rasul SAW. bilangan bacaan di setiap doa dibuat sebanyak tiga kali, karena itu adalah bilangan ganjil (witir). Semua ini berdasarkan arahan dari al Habib Abdullah bin Alwi al Haddad sendiri.
            
        """.trimIndent()


        seekhadadhistory.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            internal var p = 0
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                if (p < 14) {
                    p = 14
                    seekBar.progress = p
                }
            }

            override fun onProgressChanged(seekBar: SeekBar, progress:Int, fromUser:Boolean) {
                p = progress
                text_hadad_history.textSize = p.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
//wakwau
            }
        })

    }
}

