package Retrofit

import utils.API

class RetrofitManager {
    private var iRetrofit : IRetrofit? = RetrofitClient.getRetrifitClient(API.BASE_URL)?.create(IRetrofit::class.java)

    fun search(){
        var call =iRetrofit.searchShop(client_id = API.Client_ID, client_secret = API.Client_Secret, searhTerm = searchTerm)
    }
}