package com.example.mvvmrickymortytp.repositories

import com.example.mvvmrickymortytp.api.ApiHelper

class Repo(private val apiHelper: ApiHelper ) {
    suspend fun getAllCharacter() = apiHelper.getAllCharacter()
}