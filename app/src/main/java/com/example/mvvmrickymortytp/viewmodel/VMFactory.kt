package com.example.mvvmrickymortytp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmrickymortytp.api.ApiHelper
import com.example.mvvmrickymortytp.repositories.Repo

class VMFactory (private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(Repo(apiHelper)) as T
    }




}