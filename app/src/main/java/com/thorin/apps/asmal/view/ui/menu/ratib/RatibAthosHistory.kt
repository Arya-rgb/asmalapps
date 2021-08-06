package com.thorin.apps.asmal.view.ui.menu.ratib

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.thorin.apps.asmal.R
import kotlinx.android.synthetic.main.activity_ratib_athos_history.*

class RatibAthosHistory : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratib_athos_history)
        supportActionBar?.hide()

        text_athos_history.text = """
             Ratib ini disusun oleh al-Habib Umar bin Abdurrahman al-Attas dan sekarang telah berusia kira-kira 400 tahun. Ratib ini sehingga kini banyak dibaca di negara-negara seperti di Afrika termasuk Darussalam, Mombassa dan Afrika Selatan. Juga di England, Burma (Myanmar), India dan negara-negara Arab. Di Afrika ia disebarkan oleh murid-murid al-Habib Ahmad bin Hasan seperti al-Habib Ahmad Masyhur al-Haddad dan lain-lain. Di India, Kemboja dan Burma oleh al-Habib Abdullah bin Alawi al-Attas. Sehingga sekarang kumpulan-kumpulan ratib al-Habib Umar atau Zawiyah masih diamalkan di Rangoon dan di beberapa daerah di Burma. Tetapi mereka lebih terkenal di sana dengan Tariqah al-Attasiyah.
             
             Ratib ini telah lama sampai di Malaya, Singapura, Brunei dan Indonesia. Antara keterangan ratib ini yang diterbitkan dalam bahasa Melayu di Singapura adalah sebuah kitab kecil yang bernama Fathu Rabbin-Nas yang dikarang oleh al-Habib Husein bin Abdullah bin Muhammad bin Mohsen bin Husein al-Attas. Tarikh selesai karangan ini adalah pada pagi Jumaat 20hb Jumadil Awal 1342 (20hb Disember 1923). Ia diterbitkan dengan perbelanjaan C.H Kizar Muhammad Ain Company pengedar kain pelekat cap kerusi yang beribu pejabat di Madras, India dan dicetak oleh Qalam Singapura.
             
             Pada tahun 1939, al-Habib Muhammad bin Salim al-Attas telah menerbitkan sebuah kitab yang bernama Miftahul Imdad yang dicetak di Matbaah al-Huda di Pulau Pinang. Kitab ini mengandungi wirid-wirid datuk beliau al-Habib Ahmad bin Hasan al-Attas tetapi terdapat juga ratib al-habib Umar bin Abdurrahman al-Attas di dalamnya.
             
             Mengikut al-Habib Muhammad bin Salem al-Attas, al-Habib Hasan bin Ahmad al-Attas pada suatu masa dahulu telah mencetak Ratib al-Attas menerusi percetakannya Mutaaba\'ah al-Attas (Al-Attas Press) yang pejabatnya terletak di Wadi Hasan, Johor Bahru, Malaysia. Percetakan ini bergiat di Johor pada kira-kira tahun 1927.
        """.trimIndent()

        seekAthosFadhilah.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            internal var p = 0
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                if (p < 14) {
                    p = 14
                    seekBar.progress = p
                }
            }

            override fun onProgressChanged(seekBar: SeekBar, progress:Int, fromUser:Boolean) {
                p = progress
                text_athos_history.textSize = p.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
//wakwau
            }
        })

    }
}