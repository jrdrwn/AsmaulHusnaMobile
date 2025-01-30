package com.asmaulhusna.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.asmaulhusna.core.data.local.entity.AsmaulHusnaEntity

@Dao
interface AsmaulHusnaDao {
    @Query("SELECT * FROM asmaulhusna")
    fun getAllAsmaulHusna(): List<AsmaulHusnaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsmaulHusna(asmaulHusna: List<AsmaulHusnaEntity>)
}