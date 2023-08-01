package com.madeean.madeegram_kt.present.view.splashscreen

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.madeean.madeegram_kt.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SplashScreenActivityTest{
  @get:Rule
  val scenario = activityScenarioRule<SplashScreenActivity>()

  @Test
  fun splash(){
    Espresso.onView(withId(R.id.cl_splash)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

  }
}