package com.example.postapp.data.mapper

interface Mapper<T, E> {
    fun fromT(e: E): T
    fun toE(t: T): E
}

interface MapperList<T, E> : Mapper<T, E> {
    fun fromT(eList: List<E>): List<T>
    fun toE(tList: List<T>): List<E>
}