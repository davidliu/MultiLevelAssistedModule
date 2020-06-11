package com.deviange.multilevelassistedmodule.settings

import android.os.Bundle
import android.widget.Toast
import com.deviange.multilevelassistedmodule.AssistedModule
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SettingsActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var vmFactory: SettingsViewModel.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = vmFactory.create("settings")
        Toast.makeText(this, "settings value = ${viewModel.theValue}", Toast.LENGTH_SHORT)
            .show()
    }

    @Module(includes = [AssistedModule::class])
    object SettingsActivityModule {
        @Provides
        fun settingsRepo() = SettingsRepo()
    }
}
