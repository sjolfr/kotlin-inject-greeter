package com.fredporciuncula.inject.greeter

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Qualifier

@Qualifier annotation class SpecialGreeting1
@Qualifier annotation class SpecialGreeting2

@Module
@InstallIn(SingletonComponent::class)
object GreetingModule {
  @Provides @SpecialGreeting1
  fun provideSpecialGreeting1(): String = "Heeeeey"

  @Provides @SpecialGreeting2
  fun provideSpecialGreeting2(): String = "Oieeeee"

  @Provides @IntoSet
  fun provideEnglishGreeting(): String = "Hello"

  @Provides @IntoSet
  fun provideGermanGreeting(): String = "Hallo"

  @Provides @IntoSet
  fun providePortugueseGreeting(): String = "Olá"

  @Module
  @InstallIn(SingletonComponent::class)
  interface Bindings {
    @Binds fun bind(impl: GreetingConcatenatorImpl): GreetingConcatenator
  }
}
