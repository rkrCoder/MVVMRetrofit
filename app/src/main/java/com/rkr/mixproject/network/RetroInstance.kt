package com.rkr.mixproject.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {
        //val sURL = "https://api.github.com/search/repositories?q=newyork/"
        val sURL = "https://api.github.com/search/"
        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(sURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}