package com.example.mvvmrickymortytp.api

class ApiHelper(private val apiService: RickyAndMortyApi) {
    suspend fun getAllCharacter() = apiService.getAllCharacter()
}