package com.example.postapp.extension

import com.example.postapp.data.mapper.todo.TodoDtoEntityMapper
import com.example.postapp.data.mapper.todo.TodoEntityMapper
import com.example.postapp.data.mapper.todo.TodoMapper
import com.example.postapp.data.source.local.entity.TodoEntity
import com.example.postapp.data.source.remote.dto.TodoDto

fun List<TodoEntity>.toModelList() = TodoEntityMapper.fromT(this)

fun List<TodoDto>.asEntity() = TodoDtoEntityMapper.toE(this)

fun List<TodoDto>.asModel() = TodoMapper.toE(this)