package com.asmaulhusna.core.domain.repository

import com.asmaulhusna.core.domain.model.Settings
import kotlinx.coroutines.flow.Flow

interface ISettingsRepository {
    fun getSettings(): Flow<Settings>
    suspend fun setDarkMode(settings: Settings, state: Boolean)
}