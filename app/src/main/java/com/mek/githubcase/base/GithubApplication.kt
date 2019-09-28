package com.mek.githubcase.base

import android.app.Application
import com.mek.githubcase.di.ActivityInjector
import javax.inject.Inject

class GithubApplication : Application(){



    @Inject
    lateinit var activityInjector: ActivityInjector

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()

        component.inject(this)

    }

    fun getActivityInjectorObj(): ActivityInjector {
        return activityInjector
    }



}