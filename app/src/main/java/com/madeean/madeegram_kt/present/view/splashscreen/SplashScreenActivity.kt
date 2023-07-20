package com.madeean.madeegram_kt.present.view.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.madeean.madeegram_kt.R.layout

class SplashScreenActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.splash_screen)
  }
}