package com.example.postapp.data.repository

import com.example.postapp.data.model.Todo
import com.example.postapp.data.source.local.dao.TodoDao
import com.example.postapp.data.source.remote.ApiService
import com.example.postapp.extension.asEntity
import com.example.postapp.extension.asModel
import com.example.postapp.extension.toModelList
import com.example.postapp.utils.NetworkState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface TodoRepository {
    fun getTodos(): Flow<List<Todo>>
}

class TodoRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val todoDao: TodoDao,
    private val networkState: NetworkState
) : TodoRepository {
    override fun getTodos(): Flow<List<Todo>> {
        if (networkState.isConnected()) {
            return flow {
                val todo = apiService.getTodos()
                todoDao.saveTodos(todo.asEntity())
                emit(todo.asModel())
            }
        }
        return todoDao.getTodos().map { it.toModelList() }
    }
}