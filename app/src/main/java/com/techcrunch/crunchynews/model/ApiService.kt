package com.techcrunch.crunchynews.model

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v2/top-headlines?sources=techcrunch&apiKey=74ce38e41990461a86ace93246d7e858")
    fun getNewsData(): Call<ResponseModel>
}