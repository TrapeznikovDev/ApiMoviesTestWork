package com.template.apimovies.activities.main

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.Results
import com.template.apimovies.R

class RecyclerViewHolder(view: View, val context: Context): RecyclerView.ViewHolder(view) {

   private val title by lazy { view.findViewById(R.id.title) as TextView }
   private val description by lazy { view.findViewById(R.id.description) as TextView }
   private val image by lazy { view.findViewById(R.id.imageView) as ImageView }

    fun bind(data: Results?){
        title.text = data?.displayTitle ?: ""
        description.text = data?.summaryShort ?: ""
        Glide.with(context)
            .load(data?.multimedia?.src)
            .into(image)
    }

}