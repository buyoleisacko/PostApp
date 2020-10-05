package com.example.postapp.di.module.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.postapp.di.key.ViewModelKey
import com.example.postapp.factory.ViewModelFactory
import com.example.postapp.ui.comment.CommentViewModel
import com.example.postapp.ui.post.PostViewModel
import com.example.postapp.ui.todo.TodoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule.Binders::class])
class ViewModelModule {

    @Module
    interface Binders {
        @Binds
        fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory


        @Binds
        @IntoMap
        @ViewModelKey(TodoViewModel::class)
        fun bindCategoryViewModel(todoViewModel: TodoViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(PostViewModel::class)
        fun bindProductViewModel(postViewModel: PostViewModel): ViewModel

        @Binds
        @IntoMap
        @ViewModelKey(CommentViewModel::class)
        fun bindReviewViewModel(commentViewModel: CommentViewModel): ViewModel



    }


}