package com.thorin.apps.asmal.view.ui.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.thorin.apps.asmal.R
import com.thorin.apps.asmal.databinding.ActivityProfileBinding
import com.thorin.apps.asmal.databinding.ActivitySettingProfileBinding
import com.thorin.apps.asmal.view.LoginActivity
import java.util.*
import kotlin.collections.HashMap

class SettingProfileActivity : AppCompatActivity() {

    private var _binding: ActivitySettingProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAuth: FirebaseAuth
    private lateinit var refUser: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySettingProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()

        loadDataUser()
        supportActionBar?.hide()
        loadExtraData()

        binding.btnLogout.setOnClickListener {
            openSettingOption()
        }

        binding.btnSimpanProfile.setOnClickListener {
            upData()
        }

    }

    private fun loadExtraData() {
        binding.edtUsername.setText(intent.getStringExtra("username").toString())
        binding.edtNomer.setText(intent.getStringExtra("nomor").toString())
        binding.edtBio.setText(intent.getStringExtra("bio").toString())
        binding.edtTentang.setText(intent.getStringExtra("tentang").toString())
    }

    private fun loadDataUser() {
        Glide.with(this)
            .load(mAuth.currentUser?.photoUrl)
            .into(binding.imageviewAccountProfile)

    }

    private fun openSettingOption() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage(
            """
            Apakah Anda Yakin Untuk Keluar Akun ?
        """.trimIndent()
        )
        builder.setPositiveButton("Ya") { _, _ ->
            logOut()
        }
        builder.setNegativeButton("Tidak") { dialog, _ -> // Do nothing
            dialog.dismiss()
        }
        val alert = builder.create()
        alert.show()
    }

    private fun logOut() {
        mAuth.signOut()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun upData() {
        refUser = FirebaseDatabase.getInstance().reference.child("Users").child(mAuth.currentUser?.uid.toString())
        val userHashMap = HashMap<String, Any>()
        userHashMap["username"] = binding.edtUsername.text.toString()
        userHashMap["number"] = binding.edtNomer.text.toString()
        userHashMap["tentang"] = binding.edtTentang.text.toString()
        userHashMap["bio"] = binding.edtBio.text.toString()
        refUser.updateChildren(userHashMap)
            .addOnCompleteListener { tasks ->
                if (tasks.isSuccessful) {
                    Toast.makeText(this, "Data Berhasil Di Update", Toast.LENGTH_SHORT).show()
                    Intent(this, ProfileActivity::class.java).also {
                        startActivity(it)
                    }
                } else {
                    Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show()
                }
            }
    }


}