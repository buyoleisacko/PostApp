package com.example.postapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.postapp.data.source.local.dao.CommentDao
import com.example.postapp.data.source.local.dao.PostDao
import com.example.postapp.data.source.local.dao.TodoDao
import com.example.postapp.data.source.local.entity.CommentEntity
import com.example.postapp.data.source.local.entity.PostEntity
import com.example.postapp.data.source.local.entity.TodoEntity

@Database(
    entities = [
        PostEntity::class,
        CommentEntity::class,
        TodoEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class LocalDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun commentDao(): CommentDao
    abstract fun todoDao(): TodoDao

    companion object {
        val DATABASE_NAME = "local.db"
    }
}