package com.mek.githubcase.base

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
abstract class ApplicationModule
constructor(private var application: GithubApplication){

    @Provides
    fun provideApplicationContext(): Context = application




}