package com.rkr.mixproject.network

import com.rkr.mixproject.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")//repositories?q=newyork/
    fun getDataFromAPI(@Query("q") query: String): Call<RecyclerList>
}