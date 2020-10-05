package com.example.postapp.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postapp.data.model.Post
import com.example.postapp.data.repository.PostRepository
import com.example.postapp.ui.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class PostViewModel @Inject constructor(private val postRepository: PostRepository) :
    BaseViewModel() {

    private val _posts: MutableLiveData<Result<List<Post>>> = MutableLiveData()
    val posts: LiveData<Result<List<Post>>> = _posts

    fun loadPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                postRepository.getPosts().map {
                    return@map Result.success(it)
                }.collect {
                    isLoading.postValue(false)
                    _posts.postValue(it)
                }
            } catch (e: Exception) {
                isLoading.postValue(false)
                _posts.postValue(Result.failure(e))
            }
        }
    }
}