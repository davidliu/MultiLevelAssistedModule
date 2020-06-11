package com.deviange.multilevelassistedmodule

import com.deviange.multilevelassistedmodule.main.MainActivity
import com.deviange.multilevelassistedmodule.settings.SettingsActivity
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.DaggerApplication

class MainApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMainApplicationComponent.create()
    }
}

@Component(modules = [ActivityInjectionModule::class, AssistedModule::class])
interface MainApplicationComponent : AndroidInjector<MainApplication>

@Module(includes = [AndroidInjectionModule::class])
interface ActivityInjectionModule {
    @ContributesAndroidInjector(modules = [MainActivity.MainActivityModule::class])
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [SettingsActivity.SettingsActivityModule::class])
    fun settingsActivity(): SettingsActivity
}