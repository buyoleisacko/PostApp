package com.example.postapp.data.source.remote

import com.example.postapp.data.source.remote.dto.CommentDto
import com.example.postapp.data.source.remote.dto.PostDto
import com.example.postapp.data.source.remote.dto.TodoDto
import retrofit2.http.GET

interface ApiService {
    @GET("comments")
    suspend fun getComments(): List<CommentDto>

    @GET("posts")
    suspend fun getPosts(): List<PostDto>

    @GET("todos")
    suspend fun getTodos(): List<TodoDto>

}