package com.asmaulhusna.core.domain.usecase

import com.asmaulhusna.core.data.Resource
import com.asmaulhusna.core.domain.model.AsmaulHusna
import kotlinx.coroutines.flow.Flow

interface AsmaulHusnaUseCase {
    fun getAllAsmaulHusna(): Flow<Resource<List<AsmaulHusna>>>
    fun getFavoriteAsmaulHusna(): Flow<List<AsmaulHusna>>
    suspend fun setFavoriteAsmaulHusna(asmaulHusna: AsmaulHusna, state: Boolean)
}