package com.example.api_project.RecyclerView

import android.content.Context
import android.text.TextUtils.concat
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.api_project.App
import com.example.api_project.Model.Item
import com.example.api_project.databinding.ActivityItemViewBinding
import com.example.api_project.room.AppDatabase
import com.example.api_project.room.CartItem
import com.example.api_project.utils.constant.TAG
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

        binding.cartButton.setOnClickListener(){
            var Cartitem = item.link?.let { it1 -> CartItem(cart_title = item.title, link = it1,cart_image = item.image, cart_category1 = item.category1, cart_category2 = item.category2) }
            Log.d(TAG, "ViewHolder-bind() called, 장바구니,")
            var db = AppDatabase.getInstance(context = App.instance)

            if (Cartitem != null) {
                db!!.CartDao().inset(cartItem = Cartitem)
            }
            var dbData = db!!.CartDao().getAll()
            Log.d(TAG, "$dbData")

        }
    }

}