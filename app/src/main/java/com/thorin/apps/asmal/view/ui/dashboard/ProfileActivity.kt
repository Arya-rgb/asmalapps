package com.thorin.apps.asmal.view.ui.dashboard

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.thorin.apps.asmal.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private var _binding: ActivityProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAuth: FirebaseAuth
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        mAuth = FirebaseAuth.getInstance()
        loadDataUser()
        getUserData()
        binding.navLogout.setOnClickListener {
            val intent = Intent(this, SettingProfileActivity::class.java)
            intent.putExtra("username", binding.txtName.text)
            intent.putExtra("nomor", binding.txtNomor.text)
            intent.putExtra("bio", binding.txtBio.text)
            intent.putExtra("tentang", binding.txtTentang.text)
            startActivity(intent)
        }
    }

    private fun loadDataUser() {
        Glide.with(this)
            .load(mAuth.currentUser?.photoUrl)
            .into(binding.imgProfileUser)
    }

    private fun getUserData() {

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Mengambil Data...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        dbRef = FirebaseDatabase.getInstance().reference.child("Users")
            .child(mAuth.currentUser?.uid.toString())
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.txtName.text = snapshot.child("username").value.toString()
                binding.txtEmail.text = snapshot.child("email").value.toString()
                binding.txtNomor.text = snapshot.child("number").value.toString()
                binding.txtTentang.text = snapshot.child("tentang").value.toString()
                binding.txtBio.text = snapshot.child("bio").value.toString()
                if (progressDialog.isShowing) progressDialog.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                if (progressDialog.isShowing) progressDialog.dismiss()
            }
        })

    }
}