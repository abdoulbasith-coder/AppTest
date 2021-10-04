package com.example.sephoraapp.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    var baseUrl: String = ""
    private var interceptor: HttpLoggingInterceptor

    init {
        baseUrl = "https://sephoraios.github.io/"

        interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
    }

    private val gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()


    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()


    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}