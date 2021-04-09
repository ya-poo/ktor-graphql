package com.yapoo.graphql.repository

import com.yapoo.graphql.domain.Review

class ReviewRepository {

    fun findAllByBookId(bookId: Int) =
        reviews.filter { it.bookId == bookId }

    private val reviews: List<Review> = mutableListOf()
}
