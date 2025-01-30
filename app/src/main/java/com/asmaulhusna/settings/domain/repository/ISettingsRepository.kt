package com.asmaulhusna.settings.domain.repository

import com.asmaulhusna.settings.domain.model.Settings
import kotlinx.coroutines.flow.Flow

interface ISettingsRepository {
    fun getSettings(): Flow<Settings>
    suspend fun setDarkMode(settings: Settings, state: Boolean)
}