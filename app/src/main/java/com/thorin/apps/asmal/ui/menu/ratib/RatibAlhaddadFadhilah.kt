package com.thorin.apps.asmal.ui.menu.ratib

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.thorin.apps.asmal.R
import kotlinx.android.synthetic.main.activity_ratib_alhaddad.*
import kotlinx.android.synthetic.main.activity_ratib_alhaddad_fadhilah.*

class RatibAlhaddadFadhilah : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratib_alhaddad_fadhilah)
        supportActionBar?.hide()
        text_fadhilah_hadad.text = """
            Ratibul Haddad ini sangat dianjurkan dibaca secara bersama-sama dalam majelis dzikir. Sedangkan ketentuan waktu membacanya dijelaskan dalam penjelasan berikut:
            
            وينبغي أن يرتبه كل مرید صادق سيما إن كان صاحب الراتب واسطة له إلى الله تعالى فإن رتبه بعد صلاة العشاء والصبح فذلك هو الاكمل ويكفي ترتيبه في اليوم والليلة مرة والأفضل بعد صلاة العشاء وفى رمضان يقدم هذا الراتب على صلاة العشاء
            
            “Sebaiknya seorang murid yang sungguh-sungguh membaca ratib ini, terlebih ketika penyusun ratib ini merupakan perantara baginya menuju Allah ta’ala. Membaca ratibul haddad ini setelah shalat isya’ dan subuh adalah cara membaca yang paling sempurna, namun membaca ratib ini satu kali dalam sehari semalam dianggap cukup, yang paling utama dilakukan setelah melaksanakan shalat isya’. Sedangkan di bulan Ramadhan, membaca ratib ini didahulukan dari pelaksanaan shalat isya’” (Syekh Abu Bakar bin Ahmad al-Maliabar, al-Imdad bi Syarhi Ratib al-Haddad, Hal. 55)
            Faedah dari membaca Ratibul Hadad ini terbilang cukup banyak, berikut di antara berbagai fadilah istiqamah mengamalkan ratibul haddad
            
            و فوائد راتب الحداد منها ما نقل شراح الراتب عن صاحبه رضي الله عنه أن من واظب على قراءته حرس الله بلده أي من البلايا والنقم . ومنها زيادة الغني والبركة والخير في داره. ومنها أن من واظب عليه كل يوم لا يضره السم، ولا يضره السبع والزواحف وسائر الحيوانات. ومنها أنه يحصل عليه حسن الخاتمة ويعطيه الله له التوفيق للنطق بكلمة الشهادة.
            
            “Beberapa faedah Ratibul hadad di antaranya, penjelasan yang dikutip dari para ulama yang mensyarahi Rotib ini dari penyusun Ratib, Syekh Abdullah bin ‘alawi al-Haddad Radliyallahu ‘anhu bahwa orang yang rajin membaca rotib ini maka Allah akan menjaga negaranya dari beberapa cobaan dan siksaan. Faedah lainnya, bertambahnya kekayaan, barokah dan kebaikan di rumahnya. Orang yang rajin membaca Ratibul Haddad setiap hari, maka tidak akan bahaya baginya racun, hewan buas, reptil dan hewan-hewan lainnya. Faedah yang lain dari membaca rotib ini bahwa akan hasil baginya husnul khotimah dan Allah akan memberikan pertolongan baginya untuk mengucapkan kalimat syahadat (di Akhir Hayatnya)” (Syekh Abu Bakar bin Ahmad al-Maliabar, al-Imdad bi Syarhi Ratib al-Haddad, hal. 56)
            
            Patut dipahami bagi para pembaca Ratibul Haddad bahwa faedah-faedah di atas tentunya sekiranya tanpa memalingkan niat utama membaca Ratibul Haddad yakni mendekatkan diri kepada Allah subhanahu wa ta’ala. Semoga kita dapat mengamalkan Ratibul Haddad ini dengan istiqamah serta mendapatkan keberkahan dari penyusun Ratibul Haddad, Syekh Abdullah bin ‘alawi al-Haddad. Amin Yaa Rabbal ‘Alamin.
            
            Ustadz M. Ali Zainal Abidin, Pengajar di Pondok Pesantren Annuriyah, Kaliwining, Rambipuji, Jember
        """.trimIndent()

        seekBarfadhilahhadad.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            internal var p = 0
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                if (p < 14) {
                    p = 14
                    seekBar.progress = p
                }
            }

            override fun onProgressChanged(seekBar: SeekBar, progress:Int, fromUser:Boolean) {
                p = progress
                text_fadhilah_hadad.textSize = p.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
//wakwau
            }
        })
    }
}