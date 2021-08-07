package com.thorin.apps.asmal.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.thorin.apps.asmal.R
import com.thorin.apps.asmal.databinding.ActivityLoginBinding
import com.thorin.apps.asmal.databinding.ActivitySplashScreenBinding
import java.util.*
import kotlin.collections.HashMap

class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignClient: GoogleSignInClient
    private lateinit var refUser: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignClient = GoogleSignIn.getClient(this, gso)

        mAuth = FirebaseAuth.getInstance()

        binding.loginGoogle.setOnClickListener {
            signIn()
        }

        binding.tamuLogin.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

    }

    private fun signIn() {
        val signInIntent = googleSignClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val exception = task.exception
            if (task.isSuccessful) {
                try {
                    val account = task.getResult(ApiException::class.java)!!
                    Log.d("Sign in Activity", "FirebaseAuthWithGoogle" + account.id)
                    fireBaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    Log.w("Sign in Activity", "Google Sign in failed")
                }
            } else {
                Log.w("Sign in Activity", exception.toString())
            }
        }

    }

    private fun fireBaseAuthWithGoogle(idToken: String) {
        binding.loadingbarLogin.visibility = View.VISIBLE
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("Sign in Activity", "SignInWithCredential:success")
                    refUser = FirebaseDatabase.getInstance().reference.child("Users").child(mAuth.currentUser?.uid.toString())
                    val userHashMap = HashMap<String, Any>()
                    userHashMap["uid"] = mAuth.currentUser?.uid.toString()
                    userHashMap["profile_photo"] = mAuth.currentUser?.photoUrl.toString()
                    userHashMap["username"] = mAuth.currentUser?.displayName.toString()
                    userHashMap["email"] = mAuth.currentUser?.email.toString()
                    userHashMap["number"] = "Kosong"
                    userHashMap["tentang"] = "Kosong"
                    userHashMap["search"] = mAuth.currentUser?.displayName.toString().lowercase(
                        Locale.ROOT)
                    userHashMap["bio"] = "Kosong"
                    refUser.updateChildren(userHashMap)
                        .addOnCompleteListener { tasks ->
                            if (tasks.isSuccessful) {
                                Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show()
                            }
                        }

                    binding.loadingbarLogin.visibility = View.GONE
                    val intent = Intent(this, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()

                } else {
                    binding.loadingbarLogin.visibility = View.GONE
                    Log.w("sign in activity", "SignInWithCredential:failure")
                }
            }
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }

    companion object {
        private const val RC_SIGN_IN = 120
    }

}