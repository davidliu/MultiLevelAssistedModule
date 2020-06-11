package com.deviange.multilevelassistedmodule.main

import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class MainViewModel
@AssistedInject
constructor(
    @Assisted val name: String,
    repo: MainRepo
) {
    val theValue = repo.getMainValue()

    @AssistedInject.Factory
    interface Factory {
        fun create(name: String): MainViewModel
    }
}