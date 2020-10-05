package com.example.postapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postapp.data.source.local.entity.CommentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveComments(comments: List<CommentEntity>)

    @Query("SELECT * FROM comment")
    fun getComments(): Flow<List<CommentEntity>>
}