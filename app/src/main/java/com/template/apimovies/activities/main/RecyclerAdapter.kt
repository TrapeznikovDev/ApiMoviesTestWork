package com.template.apimovies.activities.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Results
import com.template.apimovies.R
import com.template.apimovies.utils.MyDiffUtil

class RecyclerAdapter: RecyclerView.Adapter<RecyclerViewHolder>() {

    private var items =  listOf<Results?>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_card_layout, parent, false)
        return RecyclerViewHolder(v, parent.context)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setData(newPersonalList: List<Results?>) {
        val diffUtil = MyDiffUtil(items, newPersonalList)
        val difResults = DiffUtil.calculateDiff(diffUtil)
        items = newPersonalList
        difResults.dispatchUpdatesTo(this)
    }
}