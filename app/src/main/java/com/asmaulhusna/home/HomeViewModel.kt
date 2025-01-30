package com.asmaulhusna.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.asmaulhusna.core.domain.usecase.AsmaulHusnaUseCase

class HomeViewModel(tourismUseCase: AsmaulHusnaUseCase) : ViewModel() {
    val asmaulHusna = tourismUseCase.getAllAsmaulHusna().asLiveData()
}