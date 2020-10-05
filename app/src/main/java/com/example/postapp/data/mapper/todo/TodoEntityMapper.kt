package com.example.postapp.data.mapper.todo

import com.example.postapp.data.mapper.MapperList
import com.example.postapp.data.model.Todo
import com.example.postapp.data.source.local.entity.TodoEntity

object TodoEntityMapper : MapperList<Todo, TodoEntity> {
    override fun fromT(e: TodoEntity): Todo {
        return Todo(
            id = e.id,
            completed = e.completed,
            userId = e.userId,
            title = e.title
        )
    }

    override fun toE(t: Todo): TodoEntity {
        return TodoEntity(
            id = t.id,
            completed = t.completed,
            userId = t.userId,
            title = t.title
        )
    }

    override fun fromT(eList: List<TodoEntity>): List<Todo> {
        val list = arrayListOf<Todo>()
        eList.forEach { t: TodoEntity -> list.add(fromT(t)) }
        return list
    }

    override fun toE(tList: List<Todo>): List<TodoEntity> {
        val list = arrayListOf<TodoEntity>()
        tList.forEach { t: Todo -> list.add(toE(t)) }
        return list
    }

}