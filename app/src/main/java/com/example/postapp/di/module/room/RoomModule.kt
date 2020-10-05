package com.example.postapp.di.module.room

import android.app.Application
import androidx.room.Room
import com.example.postapp.data.source.local.LocalDatabase
import com.example.postapp.data.source.local.LocalDatabase.Companion.DATABASE_NAME
import com.example.postapp.data.source.local.dao.CommentDao
import com.example.postapp.data.source.local.dao.PostDao
import com.example.postapp.data.source.local.dao.TodoDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RoomModule.Binders::class])
class RoomModule {
    @Module
    interface Binders

    @Singleton
    @Provides
    fun provideRoomDb(application: Application): LocalDatabase {
        return Room
            .databaseBuilder(
                application.applicationContext,
                LocalDatabase::class.java,
                DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(localDatabase: LocalDatabase): CommentDao = localDatabase.commentDao()

    @Singleton
    @Provides
    fun provideMessageDao(localDatabase: LocalDatabase): PostDao = localDatabase.postDao()

    @Singleton
    @Provides
    fun provideFilesDao(localDatabase: LocalDatabase): TodoDao = localDatabase.todoDao()

}