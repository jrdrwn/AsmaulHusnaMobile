package com.asmaulhusna.core.domain.usecase

import com.asmaulhusna.core.domain.repository.IAsmaulHusnaRepository

class AsmaulHusnaInteractor(private val asmaulHusnaRepository: IAsmaulHusnaRepository) :
    AsmaulHusnaUseCase {
    override fun getAllAsmaulHusna() = asmaulHusnaRepository.getAllAsmaulHusna()
}