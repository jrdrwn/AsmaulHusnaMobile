package com.asmaulhusna.core.domain.usecase

import com.asmaulhusna.core.domain.model.AsmaulHusna
import com.asmaulhusna.core.domain.repository.IAsmaulHusnaRepository

class AsmaulHusnaInteractor(private val asmaulHusnaRepository: IAsmaulHusnaRepository) :
    AsmaulHusnaUseCase {
    override fun getAllAsmaulHusna() = asmaulHusnaRepository.getAllAsmaulHusna()
    override fun getFavoriteAsmaulHusna() = asmaulHusnaRepository.getFavoriteAsmaulHusna()

    override suspend fun setFavoriteAsmaulHusna(asmaulHusna: AsmaulHusna, state: Boolean) =
        asmaulHusnaRepository.setFavoriteAsmaulHusna(asmaulHusna, state)
}