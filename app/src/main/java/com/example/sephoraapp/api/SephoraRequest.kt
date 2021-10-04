package com.example.sephoraapp.api

import com.example.sephoraapp.model.Item
import com.example.sephoraapp.model.ItemList
import retrofit2.Call
import retrofit2.http.GET

interface SephoraRequest {

    @GET("items.json")
    fun getItems() : Call<ItemList>
}