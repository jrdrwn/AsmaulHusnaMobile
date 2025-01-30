package com.asmaulhusna.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asmaulhusna.core.domain.model.AsmaulHusna
import com.asmaulhusna.core.domain.usecase.AsmaulHusnaUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val asmaulHusnaRepository: AsmaulHusnaUseCase) : ViewModel() {
    fun setFavoriteAsmaulHusna(asmaulHusna: AsmaulHusna, newStatus: Boolean) {
        viewModelScope.launch {
            asmaulHusnaRepository.setFavoriteAsmaulHusna(asmaulHusna, newStatus)
        }
    }
}