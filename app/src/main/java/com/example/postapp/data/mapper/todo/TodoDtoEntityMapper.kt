package com.example.postapp.data.mapper.todo

import com.example.postapp.data.mapper.MapperList
import com.example.postapp.data.source.local.entity.TodoEntity
import com.example.postapp.data.source.remote.dto.TodoDto

object TodoDtoEntityMapper : MapperList<TodoDto, TodoEntity> {
    override fun fromT(e: TodoEntity): TodoDto {
        return TodoDto(
            id = e.id,
            title = e.title,
            userId = e.userId,
            completed = e.completed
        )
    }

    override fun toE(t: TodoDto): TodoEntity {
        return TodoEntity(
            id = t.id,
            title = t.title,
            userId = t.userId,
            completed = t.completed
        )
    }

    override fun fromT(eList: List<TodoEntity>): List<TodoDto> {
        val list = arrayListOf<TodoDto>()
        eList.forEach { t: TodoEntity -> list.add(fromT(t)) }
        return list
    }

    override fun toE(tList: List<TodoDto>): List<TodoEntity> {
        val list = arrayListOf<TodoEntity>()
        tList.forEach { t: TodoDto -> list.add(toE(t)) }
        return list
    }

}