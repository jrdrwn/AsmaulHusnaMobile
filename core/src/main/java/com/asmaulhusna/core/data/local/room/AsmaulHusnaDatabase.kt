package com.asmaulhusna.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asmaulhusna.core.data.local.entity.AsmaulHusnaEntity

@Database(entities = [AsmaulHusnaEntity::class], version = 1, exportSchema = false)
abstract class AsmaulHusnaDatabase : RoomDatabase() {

    abstract fun asmaulHusnaDao(): AsmaulHusnaDao
}