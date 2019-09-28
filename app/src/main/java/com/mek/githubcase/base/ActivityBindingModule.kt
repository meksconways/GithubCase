package com.mek.githubcase.base

import android.app.Activity
import com.mek.githubcase.home.MainActivity
import com.mek.githubcase.home.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityBindingModule {


    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun provideMainActivity(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}