package com.example.postapp.data.mapper.todo

import com.example.postapp.data.mapper.MapperList
import com.example.postapp.data.model.Todo
import com.example.postapp.data.source.remote.dto.TodoDto

object TodoMapper : MapperList<TodoDto, Todo> {
    override fun fromT(e: Todo): TodoDto {
        return TodoDto(
            id = e.id,
            completed = e.completed,
            userId = e.userId,
            title = e.title
        )
    }

    override fun toE(t: TodoDto): Todo {
        return Todo(
            id = t.id,
            completed = t.completed,
            userId = t.userId,
            title = t.title
        )
    }


    override fun fromT(eList: List<Todo>): List<TodoDto> {
        val list = arrayListOf<TodoDto>()
        eList.forEach { t: Todo -> list.add(fromT(t)) }
        return list
    }

    override fun toE(tList: List<TodoDto>): List<Todo> {
        val list = arrayListOf<Todo>()
        tList.forEach { t: TodoDto -> list.add(toE(t)) }
        return list
    }

}