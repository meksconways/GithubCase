package com.mek.githubcase.base

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(githubApplication: GithubApplication)


}