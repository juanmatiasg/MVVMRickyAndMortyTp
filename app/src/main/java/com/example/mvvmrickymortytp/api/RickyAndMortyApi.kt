package com.example.mvvmrickymortytp.api

import com.example.mvvmrickymortytp.model.Personajes
import retrofit2.http.GET

interface RickyAndMortyApi {

    @GET("api/character")
    suspend fun getAllCharacter():Personajes

}