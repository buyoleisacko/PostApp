package com.example.postapp.ui.comment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postapp.data.model.Comment
import com.example.postapp.data.repository.CommentRepository
import com.example.postapp.ui.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class CommentViewModel @Inject constructor(private val commentRepository: CommentRepository) :
    BaseViewModel() {

    private val _comments: MutableLiveData<Result<List<Comment>>> = MutableLiveData()
    val comments: LiveData<Result<List<Comment>>> = _comments

    fun loadComments() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                commentRepository.getComments().map {
                    return@map Result.success(it)
                }.collect {
                    isLoading.postValue(false)
                    _comments.postValue(it)
                }
            } catch (e: Exception) {
                isLoading.postValue(false)
                _comments.postValue(Result.failure(e))
            }
        }
    }
}