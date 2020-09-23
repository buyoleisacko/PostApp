package com.example.postsapp.repository

import com.example.postapp.api.ApiClient
import com.example.postapp.api.ApiInterface
import com.example.postsapp.api.ApiClient
import com.example.postsapp.api.ApiInterface
import com.example.postsapp.models.Comment
import com.example.postsapp.models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CommentsRepository {
    suspend fun getComments(): Any = withContext(Dispatchers.IO){
        val apiInterface= ApiClient.buildService(ApiInterface::class.java)
        val response= apiInterface.getComments()
        return@withContext response
    }




}