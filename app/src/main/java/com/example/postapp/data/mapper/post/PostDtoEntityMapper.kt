package com.example.postapp.data.mapper.post

import com.example.postapp.data.mapper.MapperList
import com.example.postapp.data.source.local.entity.PostEntity
import com.example.postapp.data.source.remote.dto.PostDto

object PostDtoEntityMapper : MapperList<PostDto, PostEntity> {
    override fun fromT(e: PostEntity): PostDto {
        return PostDto(
            id = e.id,
            body = e.body,
            title = e.title,
            userId = e.userId
        )
    }

    override fun toE(t: PostDto): PostEntity {
        return PostEntity(
            id = t.id,
            body = t.body,
            title = t.title,
            userId = t.userId
        )
    }

    override fun fromT(eList: List<PostEntity>): List<PostDto> {
        val list = arrayListOf<PostDto>()
        eList.forEach { t: PostEntity -> list.add(fromT(t)) }
        return list
    }

    override fun toE(tList: List<PostDto>): List<PostEntity> {
        val list = arrayListOf<PostEntity>()
        tList.forEach { t: PostDto -> list.add(toE(t)) }
        return list
    }

}