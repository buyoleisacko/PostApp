package com.example.postapp.data.repository

import com.example.postapp.data.model.Comment
import com.example.postapp.data.source.local.dao.CommentDao
import com.example.postapp.data.source.remote.ApiService
import com.example.postapp.extension.asEntity
import com.example.postapp.extension.asModel
import com.example.postapp.extension.toModelList
import com.example.postapp.utils.NetworkState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface CommentRepository {
    fun getComments(): Flow<List<Comment>>
}

class CommentRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val commentDao: CommentDao,
    private val networkState: NetworkState
) : CommentRepository {
    override fun getComments(): Flow<List<Comment>> {
        if (networkState.isConnected()) {
            return flow {
                val comments = apiService.getComments()
                commentDao.saveComments(comments.asEntity())
                emit(comments.asModel())
            }
        }
        return commentDao.getComments().map { it.toModelList() }

    }

}