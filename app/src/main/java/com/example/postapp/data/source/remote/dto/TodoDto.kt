package com.example.postapp.data.source.remote.dto


import com.google.gson.annotations.SerializedName

data class TodoDto(
    @SerializedName("completed")
    val completed: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)