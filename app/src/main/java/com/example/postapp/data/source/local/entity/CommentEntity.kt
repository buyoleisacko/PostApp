package com.example.postapp.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comment")
data class CommentEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val body: String,
    val email: String,
    val name: String,
    val postId: Int
)
