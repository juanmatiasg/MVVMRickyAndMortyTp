package com.example.mvvmrickymortytp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmrickymortytp.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setActivityDetail()
    }

    private fun setActivityDetail() {

        val bundle:Bundle? = intent.extras!!
        val image = bundle!!.getString("image")
        val name = bundle.getString("name")
        val species = bundle.getString("species")
        val gender = bundle.getString("gender")
        val origin = bundle.getString("origin")
        val location = bundle.getString("location")
        val type = bundle.getString("created")

        binding.textViewNameDetail.text = "$NAME_DETAIL $name"
        binding.textViewSpecies.text = "$SPECIES_DETAIL $species"
        binding.textViewCreated.text = "$CREATED_DETAIL $type"
        binding.textViewGender.text = "$GENDER_DETAIL $gender"
        binding.textViewOrigin.text = "$ORIGIN_DETAIL $origin"
        binding.textViewLocation.text = "$LOCATION_DETAIL $location"

        Picasso.get().load(image).into(binding.imageViewDetail)
    }

    companion object{
        const val NAME_DETAIL ="Nombre: "
        const val SPECIES_DETAIL ="Especie: "
        const val GENDER_DETAIL ="Genero: "
        const val ORIGIN_DETAIL ="Origen: "
        const val LOCATION_DETAIL ="Locacion: "
        const val CREATED_DETAIL ="Creacion: "
    }



}