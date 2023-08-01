package com.madeean.madeegram_kt.present.view.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.madeean.madeegram_kt.R.layout
import com.madeean.madeegram_kt.present.view.authentication.LoginActivity

class SplashScreenActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.splash_screen)


    Handler(Looper.getMainLooper()).postDelayed({
      val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
      intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
        Intent.FLAG_ACTIVITY_CLEAR_TASK or
        Intent.FLAG_ACTIVITY_NEW_TASK
      startActivity(intent)
    }, 3000)

  }
}