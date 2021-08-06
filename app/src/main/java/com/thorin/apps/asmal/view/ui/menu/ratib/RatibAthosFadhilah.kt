package com.thorin.apps.asmal.view.ui.menu.ratib

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.thorin.apps.asmal.R
import kotlinx.android.synthetic.main.activity_ratib_athos_fadhilah.*

class RatibAthosFadhilah : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratib_athos_fadhilah)
        supportActionBar?.hide()

        text_athos_fadhilah.text = """
            Faedah membaca Ratib al-Atthas secara gamblang disebutkan dalam syarahnya, kitab Al-Qirthas Syarah Ratib al-Atthas
            
            قال السيد الإمام عیسی بن محمد الحبشي إنه قد ورد عن سيدنا عمر المذكور نفع الله به كلام كثير في فضائل هذا الراتب قال وأتى إليه أناس يشكون الجدب وضيق المعاش فأمرهم بقراءته ثم التوحيد المعروف بعده ففعلوا ففرج الله عنهم ببركته. وقال السيد المذكور أخبرني الثقة عن الشيخ علي بن عبد الله بارأس تلميذ سيدنا عمر أنه رأى كتابا فيه أن من واظب على قراءة هذا الراتب المذكور يرجی أن تغفر ذنوبه
            
            “Sayyid al-Imam ‘Isa bin Muhammad al-Habsyi berkata: ‘Diriwayatkan dari Tuanku ‘Umar penyusun Ratib al-Atthas perkataan yang cukup banyak tentang keutamaan Ratib ini. Pernah suatu ketika datang kepada Sayyid ‘Umar orang-orang yang berkeluh kesah tentang sengsara dan sulitnya mencari biaya hidup, lalu beliau memerintahkan pada mereka untuk membaca ratib ini dan membaca bacaan tauhid (Lâ ilâha illa Allâh) setelahnya. Mereka pun melakukan perintah itu, tak lama kemudian Allah memberikan kelapangan pada mereka lantaran keberkahan Ratib al-Atthas.’
            
            Berkata pula Sayyid ‘Isa: ‘Telah mengkhabarkan kepadaku orang yang terpercaya, ia meriwayatkan dari Syekh ‘Ali bin ‘Abdullah Bara’as, murid dari Sayyid ‘Umar bahwa ia melihat tulisan yang didalamnya tercatat ‘Barang siapa yang tekun mengamalkan ratib ini, maka dosa-dosanya diharapkan dapat diampuni’,” (Sayyid ‘Ali bin Hasan bin ‘Abdillah al-Atthas, Al-Qirthas Syarah Ratib al-Atthas, hal. 8).
            
            Selain itu, membaca Ratib al-Atthas juga berfaedah menjaga sebuah daerah atau perkampungan dari turunnya petaka. Seperti dijelaskan dalam lanjutan referensi di atas:
            
            وبلغنا ايضا عن الشيخ علي بن عبد الله باراس أن هذا الراتب إذا قريء في قرية أو محلة كان أمانا لأهلها من الآفات وأنه في حمايته لهم وحراسته إياهم من الآفات مثل سبعين فارسا ولاشك في ذلك ولامرية
            
            “Telah sampai padaku riwayat dari Syekh ‘Ali bin ‘Abdillah Bara’as bahwa Roti ini ketika dibaca di perkampungan atau di sebuah daerah maka penghuni perkampungan atau daerah tersebut akan aman dari petaka dan Ratib ini menjaga mereka serta melindungi mereka dari petaka, layaknya dijaga 70 penunggang kuda, hal ini sudah tidak diragukan lagi” (Sayyid ‘Ali bin Hasan bin ‘Abdillah al-Atthas, Al-Qirthas Syarah Ratib al-Atthas, hal. 9).
            
            Diriwayatkan pula bahwa orang yang membaca ratib ini sebanyak 41 kali, maka hajat-hajatnya akan dikabulkan atas seizin Allah subhanahu wa ta’ala.
            
            Sedangkan cara mengamalkan Ratib al-Atthas dapat dilakukan kapan pun, namun alangkah baiknya dibaca dengan suara yang samar atau pelan-pelan tatkala seseorang membaca ratib ini sendirian. Sedangkan saat membaca secara berjamaah atau dalam suatu majelis, maka dibaca dengan suara yang standar atau tengah-tengah, tidak terlalu pelan dan tidak terlalu keras, sekiranya orang di sampingnya dapat mendengarkan bacaannya. Hal ini seperti yang disampaikan dalam penjelasan berikut:
            
            الوا وكان سيدنا عمر يحب الإسرار بقراءته ويکره شهرته والجهر به . وذلك لأنه نفع الله به بنی أمره كله على اللطف والخمول . وأيضا فالسر أقرب إلى الإخلاص - والأحسن في قراءة هذا الراتب إذا كانوا جماعة أو أفرادا أن توسطوا فيها بين الجهر والإسرار بحيث يسمع بعضهم بعضا لقوله تعالى ( ولاتجهر بصلاتك ولا تخافت بها وابتغ بين ذلك سبيلا)
            
           “Para ulama berkata bahwa Sayyid ‘Umar senang membaca ratib ini dengan suara yang pelan, beliau tidak menyukai membaca dengan lantang dan keras. Hal ini dikarenakan beliau mendasarkan setiap urusannya atas jalan lembut dan khumul (tertutup). Selain itu, membaca secara samar lebih dekat untuk mencapai keikhlasan.”
           
            Hal yang lebih baik dalam membaca ratib ini, tatkala dibaca secara bersama-sama adalah membacanya dengan suara tengah-tengah antara keras dan pelan, sekiranya sebagian orang mendengarkan suara yang lain, hal demikian berdasarkan firman Allah: ‘Dan janganlah engkau mengeraskan suaramu dalam shalat dan janganlah (pula) merendahkannya dan usahakan jalan tengah di antara kedua itu” (Sayyid ‘Ali bin Hasan bin ‘Abdillah al-Atthas, Al-Qirthas Syarah Ratib al-Atthas, hal. 9).
            
            Dengan demikian, hendaknya bacaan Ratib al-Atthas ini diamalkan dalam keadaan suci (memiliki wudhu) dan di tempat yang sepi. Sebelum mengamalkan ratib ini, alangkah baiknya bertawasul dahulu kepada Rasulullah shallallahu ‘alaihi wa sallam, Habib ‘Umar bin ‘Abdurrahman al-Atthas (penyusun ratib ini), Syekh ‘Ali bin ‘Abdullah Bara’as, dan Habib Ahmad bin Hasan bin ‘Abdullah al-Atthas.
            
            Semoga kita dapat mengamalkan ratib al-Atthas dengan penuh khusyuk dan istiqamah, serta mendapatkan limpahan barokah dari penyusun Rotin al-Atthas serta para ulama yang mengamalkan ratib ini. Amin Yaa Rabbal ‘Alamin.
            
            Ustadz M. Ali Zainal Abidin, pengajar di Pesantren Annuriyah, Kaliwining, Rambipuji, Jember

        """.trimIndent()

        seekBarfadhilathos.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            internal var p = 0
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                if (p < 14) {
                    p = 14
                    seekBar.progress = p
                }
            }

            override fun onProgressChanged(seekBar: SeekBar, progress:Int, fromUser:Boolean) {
                p = progress
                text_athos_fadhilah.textSize = p.toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
//wakwau
            }
        })


    }


}




