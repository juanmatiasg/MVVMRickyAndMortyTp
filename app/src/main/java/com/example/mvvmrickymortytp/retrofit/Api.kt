package com.example.mvvmrickymortytp.retrofit

import com.example.mvvmrickymortytp.api.RickyAndMortyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val apiService = getRetrofit().create(RickyAndMortyApi::class.java)


}