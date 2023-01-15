package com.example.api_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_project.Model.Item
import com.example.api_project.RecyclerView.Adapter
import com.example.api_project.databinding.ActivityRecyclerViewBinding
import com.example.api_project.utils.constant.TAG

class Recycler_view : AppCompatActivity() {
    var rbinding : ActivityRecyclerViewBinding?=null
    var shoplist =ArrayList<Item>()
    lateinit var itemAdapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        rbinding = ActivityRecyclerViewBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(rbinding!!.root)

        val bundle = intent.getBundleExtra("Bundle_Array_List")
        if (bundle != null) {
            shoplist= bundle.getSerializable("Array_List") as ArrayList<Item>
            Log.d(TAG, "Recycler_view-onCreate() called$shoplist")
        }
       // Log.d(TAG, "Recycler_view-onCreate() called $shoplist")
        itemAdapter = Adapter()

        itemAdapter.submit(shoplist)

        rbinding!!.recyclerview.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        rbinding!!.recyclerview.adapter = itemAdapter
    }
}