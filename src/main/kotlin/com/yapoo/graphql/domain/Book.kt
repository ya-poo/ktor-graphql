package com.yapoo.graphql.domain

data class Book(
    val id: Int,
    val name: String,
    val authorId: Int,
)
