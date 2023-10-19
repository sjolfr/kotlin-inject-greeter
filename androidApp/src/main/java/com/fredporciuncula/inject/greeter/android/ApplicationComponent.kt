package com.fredporciuncula.inject.greeter.android

import android.app.Activity
import android.content.Context
import com.fredporciuncula.inject.greeter.GreetingComponent
import com.fredporciuncula.inject.greeter.GreetingHandler
import com.fredporciuncula.inject.greeter.PlatformComponent
import com.fredporciuncula.inject.greeter.PlatformGreeter
import com.fredporciuncula.inject.greeter.Singleton
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Inject
import me.tatarka.inject.annotations.Provides

@Component
abstract class MainActivityComponent(@Component val parent: ApplicationComponent,
                                     @get:Provides val mainActivity: Activity) {
  abstract val greetingHandlerCreator: (String) -> GreetingHandler
}

@Component @Singleton
abstract class ApplicationComponent(
  @get:Provides val context: Context,
) : PlatformComponent, GreetingComponent {
  abstract val launcher: Launcher
}

@Inject
class Launcher(val platformGreeter: PlatformGreeter)

interface ApplicationComponentProvider {
  val component: ApplicationComponent
}

val Context.applicationComponent get() = (applicationContext as ApplicationComponentProvider).component
