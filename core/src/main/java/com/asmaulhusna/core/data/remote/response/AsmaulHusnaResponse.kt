package com.asmaulhusna.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class AsmaulHusnaResponse(
    @field:SerializedName("index")
    val index: Int,

    @field:SerializedName("latin")
    val latin: String,

    @field:SerializedName("arabic")
    val arabic: String,

    @field:SerializedName("translation_id")
    val translationId: String,

    @field:SerializedName("translation_en")
    val translationEn: String,
)