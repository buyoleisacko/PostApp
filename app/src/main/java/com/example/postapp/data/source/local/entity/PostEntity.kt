package com.example.postapp.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class PostEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val body: String,
    val title: String,
    val userId: Int
)