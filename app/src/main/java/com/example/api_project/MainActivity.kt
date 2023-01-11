package com.example.api_project

import com.example.api_project.Retrofit.RetrofitManager



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.api_project.databinding.ActivityMainBinding
import com.example.api_project.utils.constant.TAG
import retrofit2.Retrofit

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
                Log.d(TAG, "MainActivity-onCreate() called $it")

            })
        }
    }
}