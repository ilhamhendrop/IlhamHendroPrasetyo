package com.greensoft.jsonmanipulation.Service.Adapter

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Placement(
    @field:SerializedName("room_id")
    var room_id: Int,
    @field:SerializedName("name")
    var name: String)
    :Parcelable