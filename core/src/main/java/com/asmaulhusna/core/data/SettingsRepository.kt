package com.asmaulhusna.core.data

import com.asmaulhusna.core.data.local.DataStoreSource
import com.asmaulhusna.core.domain.model.Settings
import com.asmaulhusna.core.domain.repository.ISettingsRepository
import kotlinx.coroutines.flow.Flow

class SettingsRepository(
    private val dataStoreSource: DataStoreSource
) : ISettingsRepository {
    override fun getSettings(): Flow<Settings> {
        return dataStoreSource.getSettings()
    }

    override suspend fun setDarkMode(settings: Settings, state: Boolean) {
        settings.darkMode = state
        dataStoreSource.saveSettings(settings)
    }
}