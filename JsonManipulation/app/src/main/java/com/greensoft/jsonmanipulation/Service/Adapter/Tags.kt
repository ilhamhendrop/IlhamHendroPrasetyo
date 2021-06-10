package com.greensoft.jsonmanipulation.Service.Adapter

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tags (
    @field:SerializedName("category")
    var category: String)
    :Parcelable