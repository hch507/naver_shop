package Retrofit

import android.util.Log
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import utils.API

class RetrofitManager {
    val TAG : String ="로그"

    companion object{
        val instance = RetrofitManager()
    }
    private var iRetrofit : IRetrofit? = RetrofitClient.getRetrifitClient(API.BASE_URL)?.create(IRetrofit::class.java)

    fun search(searchTerm : String ,completion : (String) -> Unit){
        val call = iRetrofit?.searchShop(client_id = API.Client_ID, client_secret = API.Client_Secret, searhTerm = searchTerm).let{
            it
        }?:return

        call.enqueue(object : retrofit2.Callback<JsonElement>{
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                Log.d(TAG, "RetrofitManager-onResponse() called")
                completion(response.body().toString())
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                Log.d(TAG, "RetrofitManager-onFailure() called")
            }

        })

        }



    }
