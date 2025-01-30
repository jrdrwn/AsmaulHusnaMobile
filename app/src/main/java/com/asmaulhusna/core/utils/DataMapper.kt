package com.asmaulhusna.core.utils

import com.asmaulhusna.core.data.local.entity.AsmaulHusnaEntity
import com.asmaulhusna.core.data.remote.response.AsmaulHusnaResponse
import com.asmaulhusna.core.domain.model.AsmaulHusna

object DataMapper {
    fun mapResponsesToEntities(input: List<AsmaulHusnaResponse>): List<AsmaulHusnaEntity> {
        val asmaulHusnaList = ArrayList<AsmaulHusnaEntity>()
        input.map {
            val asmaulHusna = AsmaulHusnaEntity(
                id = it.index,
                latin = it.latin,
                arabic = it.arabic,
                translationId = it.translationId,
                translationEn = it.translationEn
            )
            asmaulHusnaList.add(asmaulHusna)
        }
        return asmaulHusnaList
    }

    fun mapEntitiesToDomain(input: List<AsmaulHusnaEntity>): List<AsmaulHusna> =
        input.map {
            AsmaulHusna(
                id = it.id,
                latin = it.latin,
                arabic = it.arabic,
                translationId = it.translationId,
                translationEn = it.translationEn
            )
        }

    fun mapDomainToEntity(input: AsmaulHusna) = AsmaulHusnaEntity(
        id = input.id,
        latin = input.latin,
        arabic = input.arabic,
        translationId = input.translationId,
        translationEn = input.translationEn
    )
}