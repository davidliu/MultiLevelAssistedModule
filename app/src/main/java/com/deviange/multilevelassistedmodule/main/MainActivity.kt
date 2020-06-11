package com.deviange.multilevelassistedmodule.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.deviange.multilevelassistedmodule.AssistedModule
import com.deviange.multilevelassistedmodule.R
import com.deviange.multilevelassistedmodule.settings.SettingsActivity
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var vmFactory: MainViewModel.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val viewModel = vmFactory.create("main")
        Toast.makeText(this, "main value = ${viewModel.theValue}", Toast.LENGTH_SHORT)
            .show()

        fab.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    @Module(includes = [AssistedModule::class])
    object MainActivityModule {
        @Provides
        fun mainRepo() = MainRepo()
    }
}
