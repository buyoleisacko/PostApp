package com.example.postapp.data.repository

import com.example.postapp.data.model.Post
import com.example.postapp.data.source.local.dao.PostDao
import com.example.postapp.data.source.remote.ApiService
import com.example.postapp.extension.asEntity
import com.example.postapp.extension.asModel
import com.example.postapp.extension.toModelList
import com.example.postapp.utils.NetworkState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface PostRepository {
    fun getPosts(): Flow<List<Post>>
}

class PostRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val postDao: PostDao,
    private val networkState: NetworkState
) : PostRepository {
    override fun getPosts(): Flow<List<Post>> {
        if (networkState.isConnected()) {
            return flow {
                val post = apiService.getPosts()
                postDao.savePosts(post.asEntity())
                emit(post.asModel())
            }
        }
        return postDao.getPosts().map { it.toModelList() }

    }
}