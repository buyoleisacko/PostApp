package com.example.postapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postapp.data.source.local.entity.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePosts(posts: List<PostEntity>)

    @Query("SELECT * FROM post")
    fun getPosts(): Flow<List<PostEntity>>
}