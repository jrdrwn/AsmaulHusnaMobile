package com.asmaulhusna.core.data.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "asmaulhusna")
class AsmaulHusnaEntity(
    @PrimaryKey
    var id: Int = 0,

    @ColumnInfo(name = "latin")
    var latin: String = "",

    @ColumnInfo(name = "arabic")
    var arabic: String = "",

    @ColumnInfo(name = "translation_id")
    var translationId: String = "",

    @ColumnInfo(name = "translation_en")
    var translationEn: String = "",

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false

) : Parcelable