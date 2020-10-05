package com.example.postapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postapp.data.source.local.entity.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTodos(todos: List<TodoEntity>)

    @Query("SELECT * FROM todo")
    fun getTodos(): Flow<List<TodoEntity>>
}