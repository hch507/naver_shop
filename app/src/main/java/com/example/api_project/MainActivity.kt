package com.example.api_project

import android.content.Intent
import com.example.api_project.Retrofit.RetrofitManager



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.api_project.RecyclerView.Recycler_view
import com.example.api_project.databinding.ActivityMainBinding
import com.example.api_project.utils.RESPONSESTATE

class MainActivity : AppCompatActivity() {
    val TAG : String ="로그"
    private var mbinding  : ActivityMainBinding? = null
    private val binding get() = mbinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        mbinding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener(){
            RetrofitManager.instance.search(searchTerm = binding.edittext.text.toString(), completion = {
                    responseState, responseArrayList ->
                when(responseState){
                    RESPONSESTATE.OkAY->{
                        Log.d(TAG, "MainActivity-onCreate() called,RESPONSESTATE.OkAY ${responseArrayList} ")

                        val intent = Intent(this, Recycler_view::class.java)
                        //arraylist를 bundle에 담아 보내기
                        val bundle = Bundle()
                        bundle.putSerializable("Array_List",responseArrayList)
                        intent.putExtra("Bundle_Array_List", bundle)

                        startActivity(intent)

                    }
                    RESPONSESTATE.FALSE->{
                        Log.d(TAG, "MainActivity-onCreate() called, RESPONSESTATE.FALSE")
                    }
                }


            })
        }
    }
}