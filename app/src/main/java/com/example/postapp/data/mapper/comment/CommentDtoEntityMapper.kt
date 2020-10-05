package com.example.postapp.data.mapper.comment

import com.example.postapp.data.mapper.MapperList
import com.example.postapp.data.source.local.entity.CommentEntity
import com.example.postapp.data.source.remote.dto.CommentDto

object CommentDtoEntityMapper : MapperList<CommentDto, CommentEntity> {
    override fun fromT(e: CommentEntity): CommentDto {
        return CommentDto(
            id = e.id,
            name = e.name,
            email = e.email,
            body = e.body,
            postId = e.postId
        )
    }

    override fun toE(t: CommentDto): CommentEntity {
        return CommentEntity(
            id = t.id,
            postId = t.postId,
            body = t.body,
            email = t.email,
            name = t.name
        )
    }

    override fun fromT(eList: List<CommentEntity>): List<CommentDto> {
        val list = arrayListOf<CommentDto>()
        eList.forEach { t: CommentEntity -> list.add(fromT(t)) }
        return list
    }

    override fun toE(tList: List<CommentDto>): List<CommentEntity> {
        val list = arrayListOf<CommentEntity>()
        tList.forEach { t: CommentDto -> list.add(toE(t)) }
        return list
    }
}