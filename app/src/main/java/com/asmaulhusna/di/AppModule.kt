package com.asmaulhusna.di

import com.asmaulhusna.core.domain.usecase.AsmaulHusnaInteractor
import com.asmaulhusna.core.domain.usecase.AsmaulHusnaUseCase
import com.asmaulhusna.detail.DetailViewModel
import com.asmaulhusna.home.HomeViewModel
import com.asmaulhusna.settings.data.SettingsRepository
import com.asmaulhusna.settings.data.source.local.LocalDataSource
import com.asmaulhusna.settings.domain.repository.ISettingsRepository
import com.asmaulhusna.settings.domain.usecase.SettingsInteractor
import com.asmaulhusna.settings.domain.usecase.SettingsUseCase
import com.asmaulhusna.settings.ui.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<AsmaulHusnaUseCase> { AsmaulHusnaInteractor(get()) }
    factory<SettingsUseCase> { SettingsInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { SettingsViewModel(get()) }
}

val settingsRepositoryModule = module {
    factory { LocalDataSource(get()) }
    single<ISettingsRepository> { SettingsRepository(get()) }
}