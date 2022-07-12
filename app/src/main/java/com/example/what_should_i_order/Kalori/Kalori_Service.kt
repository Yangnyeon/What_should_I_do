package com.example.what_should_i_order.Kalori

import com.example.what_should_i_order.BuildConfig.GOOGLE_API_KEY1
import com.example.what_should_i_order.BuildConfig.GOOGLE_API_SERVICE2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Kalori_Service {
    @GET(GOOGLE_API_KEY1)
    fun getInfo(
        @Query("perPage")PerPage:Int,
        @Query("page")Page:Int,
        @Query("currentCount")currentCount:Int,
        @Query("serviceKey")ServiceKey:String = GOOGLE_API_SERVICE2
    ): Call<Food_Class>
}