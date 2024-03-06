package com.charles.toptenindonesiamovies

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val title: String,
    val description: String,
    val poster: String,
    val tahun: String,
    val penonton: String,
    val sutradara: String,
    val produksi: String
) : Parcelable
