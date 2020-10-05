package com.example.postapp.data.mapper.comment

import com.example.postapp.data.mapper.MapperList
import com.example.postapp.data.model.Comment
import com.example.postapp.data.source.remote.dto.CommentDto

object CommentMapper : MapperList<CommentDto, Comment> {
    override fun fromT(e: Comment): CommentDto {
        return CommentDto(
            id = e.id,
            body = e.body,
            name = e.name,
            email = e.email,
            postId = e.postId
        )
    }

    override fun toE(t: CommentDto): Comment {
        return Comment(
            id = t.id,
            body = t.body,
            name = t.name,
            email = t.email,
            postId = t.postId
        )
    }

    override fun fromT(eList: List<Comment>): List<CommentDto> {
        val list = arrayListOf<CommentDto>()
        eList.forEach { t: Comment -> list.add(fromT(t)) }
        return list
    }

    override fun toE(tList: List<CommentDto>): List<Comment> {
        val list = arrayListOf<Comment>()
        tList.forEach { t: CommentDto -> list.add(toE(t)) }
        return list
    }
}