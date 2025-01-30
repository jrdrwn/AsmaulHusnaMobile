package com.asmaulhusna.settings.data

import com.asmaulhusna.settings.data.source.local.LocalDataSource
import com.asmaulhusna.settings.domain.model.Settings
import com.asmaulhusna.settings.domain.repository.ISettingsRepository
import kotlinx.coroutines.flow.Flow

class SettingsRepository(
    private val localDataSource: LocalDataSource
) : ISettingsRepository {
    override fun getSettings(): Flow<Settings> {
        return localDataSource.getSettings()
    }

    override suspend fun setDarkMode(settings: Settings, state: Boolean) {
        settings.darkMode = state
        localDataSource.saveSettings(settings)
    }
}