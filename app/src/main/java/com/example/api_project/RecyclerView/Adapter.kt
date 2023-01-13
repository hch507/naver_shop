package com.example.api_project.RecyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api_project.Model.Item
import com.example.api_project.R
import com.example.api_project.databinding.ActivityItemViewBinding
import com.example.api_project.databinding.ActivityRecyclerViewBinding
import com.example.api_project.utils.constant.TAG

class Adapter : RecyclerView.Adapter<ViewHolder>() {
    private var itemList = ArrayList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "Adapter-onCreateViewHolder() called")
        val itemhodler= ViewHolder(ActivityItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        return itemhodler
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "Adapter-onBindViewHolder() called")
        holder.bind(this.itemList[position])
    }

    override fun getItemCount(): Int {
        return this.itemList.size
    }

    fun submit(itemList: ArrayList<Item>){
        this.itemList =itemList
    }
}