package com.example.postsapp.database

import androidx.lifecycle.LiveDataScope
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postapp.models.Post
import com.example.postsapp.models.Post
import java.nio.charset.CodingErrorAction.REPLACE
import retrofit2.http.Query as Query1

@Dao
interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourse(post: Post)

    @Query1(value = "SELECT * FROM posts")
    fun getPosts(): LiveDataScope<List<Post>>
}

interface OnConflictStrategy {

}

annotation class Insert(val onConflict: Any)
