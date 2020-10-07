package com.example.postapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postapp.data.model.Todo
import com.example.postapp.data.repository.TodoRepository
import com.example.postapp.ui.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class TodoViewModel @Inject constructor(private val todoRepository: TodoRepository) :
    BaseViewModel() {

    private val _todos: MutableLiveData<Result<List<Todo>>> = MutableLiveData()
    val todos: LiveData<Result<List<Todo>>> = _todos

    fun loadTodos() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                todoRepository.getTodos().map {
                    return@map Result.success(it)
                }.collect {
                    isLoading.postValue(false)
                    _todos.postValue(it)
                }
            } catch (e: Exception) {
                isLoading.postValue(false)
                _todos.postValue(Result.failure(e))
            }
        }
    }
}