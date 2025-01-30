package com.asmaulhusna.settings.domain.usecase

import com.asmaulhusna.settings.domain.model.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsUseCase {
    fun getSettings(): Flow<Settings>
    suspend fun setDarkMode(settings: Settings, state: Boolean)
}