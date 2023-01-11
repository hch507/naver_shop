package com.example.api_project.Retrofit

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface IRetrofit {
    @GET("search/shop.json")
    fun searchShop(@Header("X-Naver-Client-Id") client_id : String,
                   @Header("X-Naver-Client-Secret") client_secret : String,
                   @Query("query") searhTerm : String,
                   @Query("display") display : Int
    ) : Call<JsonElement>

}
            
