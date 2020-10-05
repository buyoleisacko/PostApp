package com.example.postapp.extension

import com.example.postapp.data.mapper.comment.CommentDtoEntityMapper
import com.example.postapp.data.mapper.comment.CommentEntityMapper
import com.example.postapp.data.mapper.comment.CommentMapper
import com.example.postapp.data.mapper.post.PostDtoEntityMapper
import com.example.postapp.data.mapper.post.PostEntityMapper
import com.example.postapp.data.mapper.post.PostMapper
import com.example.postapp.data.source.local.entity.CommentEntity
import com.example.postapp.data.source.local.entity.PostEntity
import com.example.postapp.data.source.remote.dto.CommentDto
import com.example.postapp.data.source.remote.dto.PostDto

fun List<PostEntity>.toModelList() = PostEntityMapper.fromT(this)

fun List<PostDto>.asEntity() = PostDtoEntityMapper.toE(this)

fun List<PostDto>.asModel() = PostMapper.toE(this)