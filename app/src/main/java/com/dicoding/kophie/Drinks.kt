package com.dicoding.kophie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drinks(
    val namaMinum : String,
    val deskripsi : String,
    val ingredients : String,
    val image : Int
):Parcelable
