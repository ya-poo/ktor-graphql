package com.yapoo.graphql.repository

import com.yapoo.graphql.domain.Book

class BookRepository {

    suspend fun findAll() = records

    private val records: List<Book> = listOf(
        Book(1, "春琴抄", 1),
        Book(2, "痴人の愛", 1),
        Book(3, "陰翳礼讃", 1),
        Book(4, "女生徒", 2),
        Book(5, "人間失格", 2),
        Book(6, "斜陽", 2),
        Book(7, "壁", 3),
        Book(8, "砂の女", 3),
        Book(8, "箱男", 3),
    )
}
