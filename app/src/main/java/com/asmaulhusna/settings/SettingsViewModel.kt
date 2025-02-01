package com.asmaulhusna.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.asmaulhusna.core.domain.model.Settings
import com.asmaulhusna.core.domain.usecase.SettingsUseCase
import kotlinx.coroutines.launch

class SettingsViewModel(private val settingsRepository: SettingsUseCase) : ViewModel() {

    fun getSettings() = settingsRepository.getSettings().asLiveData()
    fun setDarkMode(settings: Settings, state: Boolean) {
        viewModelScope.launch {
            settingsRepository.setDarkMode(settings, state)
        }
    }
}