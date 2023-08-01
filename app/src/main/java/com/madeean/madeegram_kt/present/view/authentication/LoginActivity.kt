package com.madeean.madeegram_kt.present.view.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.madeean.madeegram_kt.R
import com.madeean.madeegram_kt.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
  private lateinit var binding: ActivityLoginBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    binding = ActivityLoginBinding.inflate(layoutInflater)
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
    gotoRegisterPage()
    loginHandler()
  }

   fun loginHandler() {
    binding.btnLogin.setOnClickListener {
      if (validasiLogin()) {
        return@setOnClickListener
      }
      Toast.makeText(
        this@LoginActivity,
        "${binding.etEmail.text} - ${binding.etPassword.text}",
        Toast.LENGTH_SHORT
      ).show()
    }
  }

   fun validasiLogin(): Boolean {
    val email = binding.etEmail.text
    val password = binding.etPassword.text
    if (email.isNullOrBlank() || password.isNullOrBlank()) {
      return true
    }
    return false
  }

  private fun gotoRegisterPage() {
    binding.tvRegister.setOnClickListener {
      startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
    }
  }

  override fun onResume() {
    super.onResume()
    clearForm()
  }

  private fun clearForm() {
    binding.apply {
      etEmail.text.clear()
      etPassword.text.clear()
    }
  }
}