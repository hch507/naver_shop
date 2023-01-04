package Retrofit

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface IRetrofit {
    @GET("search/shop")
    fun searchShop(@Header("X-Naver-Client-Id") client_id : String,
                   @Header("X-Naver-Client-Secret") client_secret : String,
                   @Query("query") searhTerm : String
    ) : Call<JsonElement>

}
            
