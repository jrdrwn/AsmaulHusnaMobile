package com.asmaulhusna.settings.data.source.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.asmaulhusna.settings.domain.model.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class LocalDataSource(context: Context) {

    private var appContext = context.applicationContext

    fun getSettings(): Flow<Settings> {
        return appContext.dataStore.data.map {
            Settings(
                darkMode = it[DARK_MODE_KEY] ?: false
            )
        }
    }

    suspend fun saveSettings(settings: Settings) {
        appContext.dataStore.edit {
            it[DARK_MODE_KEY] = settings.darkMode
        }
    }

    companion object {
        private val DARK_MODE_KEY = booleanPreferencesKey("dark_mode")
    }
}