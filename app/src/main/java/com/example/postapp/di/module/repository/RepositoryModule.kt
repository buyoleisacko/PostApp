package com.example.postapp.di.module.repository

import com.example.postapp.data.repository.*
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule.Binders::class])
class RepositoryModule {
    @Module
    interface Binders {
        @Binds
        fun bindPostRepository(postRepository: PostRepositoryImpl): PostRepository

        @Binds
        fun bindCommentRepository(commentRepository: CommentRepositoryImpl): CommentRepository

        @Binds
        fun bindTodoRepository(todoRepository: TodoRepositoryImpl): TodoRepository

    }
}