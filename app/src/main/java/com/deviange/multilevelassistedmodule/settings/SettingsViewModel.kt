package com.deviange.multilevelassistedmodule.settings

import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class SettingsViewModel
@AssistedInject
constructor(
    @Assisted val name: String,
    repo: SettingsRepo
) {
    val theValue = repo.getSettingsValue()

    @AssistedInject.Factory
    interface Factory {
        fun create(name: String): SettingsViewModel
    }
}