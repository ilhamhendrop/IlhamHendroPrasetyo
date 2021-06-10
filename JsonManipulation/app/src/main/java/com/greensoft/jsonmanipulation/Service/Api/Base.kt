package com.greensoft.jsonmanipulation.Service.Api

import com.greensoft.jsonmanipulation.Service.Adapter.respone.IventoryRespone
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET

interface Base {
    @GET("")
    fun getElectronic(@Field("type") type: String): Call<IventoryRespone>

    @GET("")
    fun getMeeting(@Field("name") name: String): Call<IventoryRespone>
}