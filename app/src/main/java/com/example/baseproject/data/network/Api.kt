package com.example.baseproject.data.network

import com.example.baseproject.data.model.Location
import com.example.baseproject.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface Api {
    @GET(Constants.LOCATION_PATH)
    suspend fun getLocations(@Query("query") key: String): Response<List<Location>>

    companion object {
        fun getInstance(): Api {
            val okHttps = OkHttpClient.Builder()
                .readTimeout(2000, TimeUnit.MILLISECONDS)
                .connectTimeout(2000, TimeUnit.MILLISECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttps)
                .build()
            return retrofit.create(Api::class.java)
        }
    }
}