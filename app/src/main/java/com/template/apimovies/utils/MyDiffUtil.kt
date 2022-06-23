package com.template.apimovies.utils

import androidx.recyclerview.widget.DiffUtil
import com.template.apimovies.data.Results

class MyDiffUtil(
    private var oldList: List<Results?>,
    private var newList: List<Results?>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]?.displayTitle == newList[newItemPosition]?.displayTitle
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition]?.displayTitle != newList[newItemPosition]?.displayTitle ->{
                false
            }else -> true
        }
    }
}