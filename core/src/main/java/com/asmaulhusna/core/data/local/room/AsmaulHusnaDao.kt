package com.asmaulhusna.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.asmaulhusna.core.data.local.entity.AsmaulHusnaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AsmaulHusnaDao {
    @Query("SELECT * FROM asmaulhusna")
    fun getAllAsmaulHusna(): Flow<List<AsmaulHusnaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsmaulHusna(asmaulHusna: List<AsmaulHusnaEntity>)

    @Update
    suspend fun updateFavoriteAsmaulHusna(asmaulHusna: AsmaulHusnaEntity)

    @Query("SELECT * FROM asmaulhusna where isFavorite = 1")
    fun getFavoriteAsmaulHusna(): Flow<List<AsmaulHusnaEntity>>
}