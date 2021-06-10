package com.greensoft.jsonmanipulation.Service.Adapter.respone

import com.google.gson.annotations.SerializedName
import com.greensoft.jsonmanipulation.Service.Adapter.Iventory

data class IventoryRespone (
    @field:SerializedName("iventory")
    var iventory: List<Iventory>
        )