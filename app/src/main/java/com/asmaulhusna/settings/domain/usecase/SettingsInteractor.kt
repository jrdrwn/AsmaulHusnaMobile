package com.asmaulhusna.settings.domain.usecase

import com.asmaulhusna.settings.domain.model.Settings
import com.asmaulhusna.settings.domain.repository.ISettingsRepository

class SettingsInteractor(private val settingsRepository: ISettingsRepository) : SettingsUseCase {
    override fun getSettings() = settingsRepository.getSettings()

    override suspend fun setDarkMode(settings: Settings, state: Boolean) =
        settingsRepository.setDarkMode(settings, state)
}