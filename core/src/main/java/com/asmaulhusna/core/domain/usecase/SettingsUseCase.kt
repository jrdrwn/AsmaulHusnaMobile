package com.asmaulhusna.core.domain.usecase

import com.asmaulhusna.core.domain.model.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsUseCase {
    fun getSettings(): Flow<Settings>
    suspend fun setDarkMode(settings: Settings, state: Boolean)
}