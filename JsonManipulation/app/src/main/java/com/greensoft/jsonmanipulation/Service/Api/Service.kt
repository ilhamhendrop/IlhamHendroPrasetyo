package com.greensoft.jsonmanipulation.Service.Api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    fun getApi() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() = getApi().create(Base::class.java)
}