package com.example.mvvmrickymortytp.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmrickymortytp.R

import com.example.mvvmrickymortytp.model.Items
import com.example.mvvmrickymortytp.model.Personajes
import com.squareup.picasso.Picasso

class AdapterCharacter(private val lista:ArrayList<Items>):RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_character,parent,false))
    }

    override fun getItemCount(): Int {
        return this.lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = lista[position].id.toString()
        holder.name.text = lista[position].name
        holder.status.text = lista[position].status
        Picasso.get().load(lista[position].image).into(holder.imageView)

        
        if(lista[position].status =="Alive"){
            holder.imageViewCircle.setImageResource(R.drawable.ic_circle_alive)
        }

        if(lista[position].status =="Dead"){
            holder.imageViewCircle.setImageResource(R.drawable.ic_circle_dead)
        }

        if(lista[position].status =="unknown"){
            holder.imageViewCircle.setImageResource(R.drawable.ic_circle_unknown)
        }

        holder.cardView.setOnClickListener { v ->
            val intent = Intent(v.context,DetailActivity::class.java)
            intent.putExtra("image",lista[position].image)
            intent.putExtra("name",lista[position].name)
            intent.putExtra("species",lista[position].species)
            intent.putExtra("created",lista[position].created)
            intent.putExtra("gender",lista[position].gender)
            intent.putExtra("origin",lista[position].origin.name)
            intent.putExtra("location",lista[position].location.name)
            v.context.startActivity(intent)
        }
    }

    fun getAddListCharacter(list:ArrayList<Items>) {
        lista.clear()
        lista.addAll(list)
        notifyDataSetChanged()
    }







}


