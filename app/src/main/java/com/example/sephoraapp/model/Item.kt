package com.example.sephoraapp.model

import com.google.gson.annotations.Expose


data class Item(
    @Expose
    var id: String = "",

    @Expose(deserialize = false)
    var description: String = "",

    @Expose(deserialize = false)
    var location : String = "",

    @Expose
    var image: String = ""
)