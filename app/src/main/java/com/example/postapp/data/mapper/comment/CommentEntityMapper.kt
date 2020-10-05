package com.example.postapp.data.mapper.comment

import com.example.postapp.data.mapper.MapperList
import com.example.postapp.data.model.Comment
import com.example.postapp.data.source.local.entity.CommentEntity

object CommentEntityMapper : MapperList<Comment, CommentEntity> {
    override fun fromT(e: CommentEntity): Comment {
        return Comment(
            id = e.id,
            name = e.name,
            email = e.email,
            body = e.body,
            postId = e.postId
        )
    }

    override fun toE(t: Comment): CommentEntity {
        return CommentEntity(
            id = t.id,
            postId = t.postId,
            body = t.body,
            email = t.email,
            name = t.name
        )
    }

    override fun fromT(eList: List<CommentEntity>): List<Comment> {
        val list = arrayListOf<Comment>()
        eList.forEach { t: CommentEntity -> list.add(fromT(t)) }
        return list
    }

    override fun toE(tList: List<Comment>): List<CommentEntity> {
        val list = arrayListOf<CommentEntity>()
        tList.forEach { t: Comment -> list.add(toE(t)) }
        return list
    }
}