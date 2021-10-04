package com.example.sephoraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.sephoraapp.api.RetrofitClient
import com.example.sephoraapp.api.SephoraRequest
import com.example.sephoraapp.model.ItemList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.list_items)

        val service = RetrofitClient.retrofit.create(SephoraRequest::class.java)

        service.getItems().enqueue(object: Callback<ItemList> {
            override fun onResponse(call: Call<ItemList>, response: Response<ItemList>) {
                Log.d("retrofit","onsuccess : " + response.isSuccessful)
            }

            override fun onFailure(call: Call<ItemList>, t: Throwable) {
                Log.d("retrofit","onfailure : " + t.toString())

            }
        })
    }
}