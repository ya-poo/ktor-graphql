package com.yapoo.graphql.domain

data class Review(
    val id: Int,
    val bookId: Int,
    val stars: Int,
    val commentary: String,
)
