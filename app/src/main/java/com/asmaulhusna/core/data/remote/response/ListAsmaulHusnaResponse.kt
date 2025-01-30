package com.asmaulhusna.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListAsmaulHusnaResponse(
    @field:SerializedName("data")
    val data: List<AsmaulHusnaResponse>
)