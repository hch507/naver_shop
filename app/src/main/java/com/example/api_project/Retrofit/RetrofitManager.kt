package com.example.api_project.Retrofit

import android.util.Log
import com.example.api_project.Model.Item
import com.example.api_project.utils.API
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response


class RetrofitManager {
    val TAG : String ="로그"

    companion object{
        val instance = RetrofitManager()
    }
    private var iRetrofit : IRetrofit? = RetrofitClient.getRetrifitClient(API.BASE_URL)?.create(IRetrofit::class.java)

    fun search(searchTerm : String ,completion : (ArrayList<Item>) -> Unit){
        Log.d(TAG, "RetrofitManager-search() called $searchTerm")
        val call = iRetrofit?.searchShop(client_id = API.Client_ID, client_secret = API.Client_Secret, searhTerm = searchTerm, display = 10).let{
            it
        }?:return

        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                when(response.code()){
                    200->{
                        var itemArrayList = ArrayList<Item>()
                        val body = response.body()?.asJsonObject
                        val item = body?.getAsJsonArray("items")

                        if (item != null) {
                            item.forEach {
                                var itemObject = it.asJsonObject
                                var name = itemObject.get("title").asString
                                var link = itemObject.get("link").asString
                                var image = itemObject.get("image").asString
                                var category1 = itemObject.get("category1").asString
                                var category2 = itemObject.get("category2").asString

                                var itemArray = Item(name=name, link=link, image=image, category1=category1, category2=category2)

                                itemArrayList.add(itemArray)
                            }
                        }
                        completion(itemArrayList)
                    }

                }

                Log.d(TAG, "RetrofitManager-onResponse() called")

            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager-onFailure() called")
            }

        })

        }



    }
