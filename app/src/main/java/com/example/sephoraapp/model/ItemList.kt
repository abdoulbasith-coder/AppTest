package com.example.sephoraapp.model

import com.google.gson.annotations.Expose

data class ItemList(

    @Expose
    var items: List<Item>
)
