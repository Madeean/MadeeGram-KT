package com.madeean.madeegram_kt.present.view.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.madeean.madeegram_kt.R
import com.madeean.madeegram_kt.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
  private lateinit var binding: ActivityRegisterBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    binding = ActivityRegisterBinding.inflate(layoutInflater)
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
    gotoLoginPage()
    registerHandler()
  }

  private fun registerHandler() {
    binding.btnRegister.setOnClickListener {
      if (validasiRegister()) {
        return@setOnClickListener
      }
      Toast.makeText(
        this@RegisterActivity,
        "${binding.etEmail.text} - ${binding.etPassword.text}",
        Toast.LENGTH_SHORT
      ).show()
      startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))

    }
  }

  private fun validasiRegister(): Boolean {
    val username = binding.etUsername.text
    val email = binding.etEmail.text
    val password = binding.etPassword.text
    if (email.isNullOrBlank() || password.isNullOrBlank() || username.isNullOrBlank()) {
      return true
    }
    return false
  }

  private fun gotoLoginPage() {
    binding.tvLogin.setOnClickListener {
      startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
    }
  }
}