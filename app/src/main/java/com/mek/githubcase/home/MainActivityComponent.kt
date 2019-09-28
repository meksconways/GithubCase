package com.mek.githubcase.home

import com.mek.githubcase.di.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent
interface MainActivityComponent : AndroidInjector<MainActivity> {


    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>() {

        override fun seedInstance(instance: MainActivity?) {

        }

    }

}