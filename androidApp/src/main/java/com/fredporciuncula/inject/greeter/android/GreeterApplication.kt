package com.fredporciuncula.inject.greeter.android

import android.app.Application

class GreeterApplication : Application(), ApplicationComponentProvider {
  override val component by lazy(LazyThreadSafetyMode.NONE) {
    ApplicationComponent::class.create(applicationContext)
  }

  override fun onCreate() {
    super.onCreate()
    component.launcher.platformGreeter
  }
}
