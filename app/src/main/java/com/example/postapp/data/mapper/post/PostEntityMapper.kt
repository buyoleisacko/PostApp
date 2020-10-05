package com.example.postapp.data.mapper.post

import com.example.postapp.data.mapper.MapperList
import com.example.postapp.data.model.Post
import com.example.postapp.data.source.local.entity.PostEntity

object PostEntityMapper : MapperList<Post, PostEntity> {
    override fun fromT(e: PostEntity): Post {
        return Post(
            id = e.id,
            userId = e.userId,
            title = e.title,
            body = e.body
        )
    }

    override fun toE(t: Post): PostEntity {
        return PostEntity(
            id = t.id,
            userId = t.userId,
            title = t.title,
            body = t.body
        )
    }

    override fun fromT(eList: List<PostEntity>): List<Post> {
        val list = arrayListOf<Post>()
        eList.forEach { t: PostEntity -> list.add(fromT(t)) }
        return list
    }

    override fun toE(tList: List<Post>): List<PostEntity> {
        val list = arrayListOf<PostEntity>()
        tList.forEach { t: Post -> list.add(toE(t)) }
        return list
    }

}