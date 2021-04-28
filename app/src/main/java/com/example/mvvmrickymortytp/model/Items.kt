package com.example.mvvmrickymortytp.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class Items(
    @SerializedName("id")
    var id:Int,
    @SerializedName("name")
    var name:String,
    @SerializedName("status")
    var status:String,
    @SerializedName("image")
    var image:String,
    @SerializedName("species")
    var species:String,
    @SerializedName("origin")
    var origin:Origin,
    @SerializedName("gender")
    var gender:String,
    @SerializedName("location")
    var location:Location,
    @SerializedName("created")
    var created:String
)