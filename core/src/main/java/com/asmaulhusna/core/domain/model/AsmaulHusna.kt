package com.asmaulhusna.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AsmaulHusna(
    val id: Int,
    val latin: String,
    val arabic: String,
    val translationId: String,
    val translationEn: String,
) : Parcelable
