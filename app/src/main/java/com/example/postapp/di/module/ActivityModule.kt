package com.example.postapp.di.module

import com.example.postapp.ui.MainActivity
import com.example.postapp.ui.comment.CommentFragment
import com.example.postapp.ui.post.PostFragment
import com.example.postapp.ui.todo.TodoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    fun contributeMainActivity(): MainActivity
}

@Module
interface FragmentModule {
    @ContributesAndroidInjector
    fun contributePostFragment(): PostFragment

    @ContributesAndroidInjector
    fun contributeCommentFragment(): CommentFragment

    @ContributesAndroidInjector
    fun contributeTodoFragment(): TodoFragment
}
