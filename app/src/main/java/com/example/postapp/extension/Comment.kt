package com.example.postapp.extension

import com.example.postapp.data.mapper.comment.CommentDtoEntityMapper
import com.example.postapp.data.mapper.comment.CommentEntityMapper
import com.example.postapp.data.mapper.comment.CommentMapper
import com.example.postapp.data.source.local.entity.CommentEntity
import com.example.postapp.data.source.remote.dto.CommentDto

fun List<CommentEntity>.toModelList() = CommentEntityMapper.fromT(this)

fun List<CommentDto>.asEntity() = CommentDtoEntityMapper.toE(this)

fun List<CommentDto>.asModel() = CommentMapper.toE(this)