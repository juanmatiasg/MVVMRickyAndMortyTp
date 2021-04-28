package com.example.mvvmrickymortytp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmrickymortytp.repositories.Repo
import com.example.mvvmrickymortytp.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val repo: Repo) : ViewModel() {

    fun getAllCharacter() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))

        try {
            emit(Resource.success(data = repo.getAllCharacter()))
        } catch (e: Exception) {
            emit(Resource.error(data = null,message = e.message ?: "Ocurrio un error"))
        }
    }
}