package com.example.dynamicui.services

import Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("response.json")
    fun getForm(): Call<Json4Kotlin_Base>
}