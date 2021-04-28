package com.example.mvvmrickymortytp.ui

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmrickymortytp.api.ApiHelper


import com.example.mvvmrickymortytp.databinding.ActivityMainBinding
import com.example.mvvmrickymortytp.model.Items
import com.example.mvvmrickymortytp.model.Personajes
import com.example.mvvmrickymortytp.repositories.Repo
import com.example.mvvmrickymortytp.retrofit.Api
import com.example.mvvmrickymortytp.utils.Resource
import com.example.mvvmrickymortytp.utils.Status
import com.example.mvvmrickymortytp.viewmodel.MainViewModel
import com.example.mvvmrickymortytp.viewmodel.VMFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapterCharacter: AdapterCharacter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        mainViewModel.getAllCharacter().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                    }

                    Status.SUCCESS -> {
                        resource.data?.let{
                            getRetrieveList(it.results)
                        }
                    }

                    Status.ERROR -> {
                    }
                }
            }
        })
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            VMFactory(ApiHelper(Api.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupRecyclerView() {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = GridLayoutManager(this,2)
        adapterCharacter = AdapterCharacter(arrayListOf())
        binding.recyclerView.adapter = adapterCharacter
    }

    private fun getRetrieveList(list:ArrayList<Items>){
        adapterCharacter.getAddListCharacter(list)
    }
}