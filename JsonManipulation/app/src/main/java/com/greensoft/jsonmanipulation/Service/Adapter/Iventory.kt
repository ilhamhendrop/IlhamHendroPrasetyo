package com.greensoft.jsonmanipulation.Service.Adapter

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Iventory (
    @field:SerializedName("iventori_id")
    var iventori_id: Int,
    @field:SerializedName("name")
    var name: String,
    @field:SerializedName("type")
    var type: String,
    @field:SerializedName("tags")
    var tags: List<Tags>,
    @field:SerializedName("purchased_at")
    var purchased_at: Int,
    @field:SerializedName("placement")
    var Placement: List<Placement>) : Parcelable
