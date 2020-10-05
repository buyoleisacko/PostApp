package com.example.postapp.data.mapper.post

import com.example.postapp.data.mapper.MapperList
import com.example.postapp.data.model.Post
import com.example.postapp.data.source.remote.dto.PostDto

object PostMapper : MapperList<PostDto, Post> {
    override fun fromT(e: Post): PostDto {
        return PostDto(
            id = e.id,
            userId = e.userId,
            title = e.title,
            body = e.body
        )
    }

    override fun toE(t: PostDto): Post {
        return Post(
            id = t.id,
            userId = t.userId,
            title = t.title,
            body = t.body
        )
    }

    override fun fromT(eList: List<Post>): List<PostDto> {
        val list = arrayListOf<PostDto>()
        eList.forEach { t: Post -> list.add(fromT(t)) }
        return list
    }

    override fun toE(tList: List<PostDto>): List<Post> {
        val list = arrayListOf<Post>()
        tList.forEach { t: PostDto -> list.add(toE(t)) }
        return list
    }
}