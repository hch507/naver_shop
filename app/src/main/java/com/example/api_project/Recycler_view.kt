package com.example.api_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.api_project.Model.Item
import com.example.api_project.databinding.ActivityRecyclerViewBinding

class Recycler_view : AppCompatActivity() {
    var rbinding : ActivityRecyclerViewBinding?=null
    var shoplist =ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        rbinding = ActivityRecyclerViewBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(rbinding!!.root)

        val bundle = intent.getBundleExtra("bundle_Array_List")
        shoplist= bundle?.getSerializable("Array_List") as ArrayList<Item>


    }
}