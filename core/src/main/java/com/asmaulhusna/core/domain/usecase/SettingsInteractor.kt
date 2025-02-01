package com.asmaulhusna.core.domain.usecase

import com.asmaulhusna.core.domain.model.Settings
import com.asmaulhusna.core.domain.repository.ISettingsRepository

class SettingsInteractor(private val settingsRepository: ISettingsRepository) : SettingsUseCase {
    override fun getSettings() = settingsRepository.getSettings()

    override suspend fun setDarkMode(settings: Settings, state: Boolean) =
        settingsRepository.setDarkMode(settings, state)
}