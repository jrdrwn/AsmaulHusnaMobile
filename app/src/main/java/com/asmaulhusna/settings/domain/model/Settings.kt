package com.asmaulhusna.settings.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Settings(
    var darkMode: Boolean = false
) : Parcelable