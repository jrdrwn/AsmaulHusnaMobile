package com.asmaulhusna.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.asmaulhusna.core.domain.usecase.AsmaulHusnaUseCase

class FavoriteViewModel(asmaulHusnaRepository: AsmaulHusnaUseCase) : ViewModel() {
    val favoriteAsmaulHusna = asmaulHusnaRepository.getFavoriteAsmaulHusna().asLiveData()
}