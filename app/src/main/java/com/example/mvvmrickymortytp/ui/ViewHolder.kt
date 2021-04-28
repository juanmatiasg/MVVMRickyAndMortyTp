package com.example.mvvmrickymortytp.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmrickymortytp.R

class ViewHolder (view: View):RecyclerView.ViewHolder(view){
    val id = view.findViewById<TextView>(R.id.textViewId)
    val name = view.findViewById<TextView>(R.id.textViewName)
    val status = view.findViewById<TextView>(R.id.textViewStatus)
    val imageView = view.findViewById<ImageView>(R.id.imageView)
    val imageViewCircle = view.findViewById<ImageView>(R.id.imageViewCircle)
    val cardView = view.findViewById<CardView>(R.id.cardView)
}