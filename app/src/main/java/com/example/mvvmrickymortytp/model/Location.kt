package com.example.mvvmrickymortytp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Location(
    @SerializedName("name")
    var name:String
)