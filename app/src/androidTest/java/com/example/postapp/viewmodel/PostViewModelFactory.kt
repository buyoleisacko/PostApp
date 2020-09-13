package com.example.postapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.postapp.repository.PostRepository



class PostViewModelFactory(val postRepository: PostRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            return PostViewModel(this.postRepository) as T

        }
        throw IllegalAccessException("Unkown viewmodel class")
    }
}