package com.thorin.apps.asmal.view.ui.amalnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.thorin.apps.asmal.databinding.ActivityLoginBinding
import com.thorin.apps.asmal.databinding.ActivityNotesAmalBinding

class NotesAmalActivity : AppCompatActivity() {

    private var _binding: ActivityNotesAmalBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNotesAmalBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}