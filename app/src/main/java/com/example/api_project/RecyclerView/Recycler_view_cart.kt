package com.example.api_project.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api_project.databinding.ActivityRecyclerViewCartBinding

class Recycler_view_cart : AppCompatActivity() {
    var cartBinding : ActivityRecyclerViewCartBinding? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        cartBinding = ActivityRecyclerViewCartBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(cartBinding!!.root)


    }
}