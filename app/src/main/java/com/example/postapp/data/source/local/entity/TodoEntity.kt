package com.example.postapp.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val completed: Boolean,
    val title: String,
    val userId: Int
)