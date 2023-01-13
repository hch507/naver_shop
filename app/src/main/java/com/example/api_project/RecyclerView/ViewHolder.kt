package com.example.api_project.RecyclerView

import android.text.TextUtils.concat
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_project.App
import com.example.api_project.Model.Item
import com.example.api_project.databinding.ActivityItemViewBinding
import com.example.api_project.utils.constant.blank

class ViewHolder(val binding : ActivityItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item){

        binding.title.text = item.title
        binding.link.text = item.link
        binding.catecory.text = concat(item.category1,blank,item.category2)

        Glide
            .with(App.instance)
            .load(item.image)
            .into(binding.image)
    }
}