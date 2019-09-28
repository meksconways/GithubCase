package com.mek.githubcase.base

import android.app.Application

class GithubApplication : Application(){


    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()



    }

}