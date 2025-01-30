package com.asmaulhusna.di

import com.asmaulhusna.core.domain.usecase.AsmaulHusnaInteractor
import com.asmaulhusna.core.domain.usecase.AsmaulHusnaUseCase
import com.asmaulhusna.detail.DetailViewModel
import com.asmaulhusna.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<AsmaulHusnaUseCase> { AsmaulHusnaInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}