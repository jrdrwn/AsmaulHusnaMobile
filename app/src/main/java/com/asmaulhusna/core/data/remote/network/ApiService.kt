package com.asmaulhusna.core.data.remote.network

import com.asmaulhusna.core.data.remote.response.ListAsmaulHusnaResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/asmaulhusna")
    suspend fun getList(): ListAsmaulHusnaResponse
}