package com.thorin.apps.asmal.ui.menu.tasbih

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thorin.apps.asmal.R
import kotlinx.android.synthetic.main.activity_tasbih.*

class TasbihActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasbih)

        freethrowA_btn.setOnClickListener {
            scoreA += 1
            displayForTeamA(scoreA)
        }

        freethrowB_btn.setOnClickListener {
            scoreB += 1
            displayForTeamB(scoreB)
        }

        reset_btn.setOnClickListener {
            scoreA = 0
            scoreB = 0
            displayForTeamA(scoreA)
            displayForTeamB(scoreB)
        }
    }

    var scoreA = 0
    var scoreB = 0

    private fun displayForTeamA(number: Int) {
        scoreA_textView.text = scoreA.toString()
    }

    private fun displayForTeamB(number: Int) {
        scoreB_textView.text = scoreB.toString()
    }

}
