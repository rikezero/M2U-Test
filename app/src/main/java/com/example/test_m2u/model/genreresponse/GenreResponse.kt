package com.example.test_m2u.model.genreresponse


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class GenreResponse(
    @SerializedName("genres")
    val genres: List<Genre>
) : Parcelable