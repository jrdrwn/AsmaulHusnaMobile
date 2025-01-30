package com.asmaulhusna.core.data

import com.asmaulhusna.core.data.local.room.AsmaulHusnaDao
import com.asmaulhusna.core.data.remote.network.ApiService
import com.asmaulhusna.core.domain.model.AsmaulHusna
import com.asmaulhusna.core.domain.repository.IAsmaulHusnaRepository
import com.asmaulhusna.core.utils.DataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AsmaulHusnaRepository(
    private val apiService: ApiService,
    private val asmaulHusnaDao: AsmaulHusnaDao
) : IAsmaulHusnaRepository {
    override fun getAllAsmaulHusna(): Flow<Resource<List<AsmaulHusna>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val response = apiService.getList()
                val data = DataMapper.mapResponsesToEntities(response.data)
                asmaulHusnaDao.insertAsmaulHusna(data)
            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
            } finally {
                val data = asmaulHusnaDao.getAllAsmaulHusna()
                emit(Resource.Success(DataMapper.mapEntitiesToDomain(data)))
            }
        }.flowOn(Dispatchers.IO)
    }

}