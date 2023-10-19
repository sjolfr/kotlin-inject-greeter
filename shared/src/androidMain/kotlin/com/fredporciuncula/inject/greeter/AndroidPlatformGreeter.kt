package com.fredporciuncula.inject.greeter

import android.app.Activity
import android.content.Context
import android.widget.Toast
import me.tatarka.inject.annotations.Inject

@Inject @Singleton
class AndroidPlatformGreeter(
  private val context: Context,
  private val mainActivity: Activity
) : PlatformGreeter {
  override fun greet(finalGreeting: String) {
    println(mainActivity.localClassName)
    Toast.makeText(context, finalGreeting, Toast.LENGTH_SHORT).show()
  }
}
