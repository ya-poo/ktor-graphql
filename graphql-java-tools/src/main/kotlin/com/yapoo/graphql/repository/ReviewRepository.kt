package com.yapoo.graphql.repository

import com.yapoo.graphql.domain.Review

class ReviewRepository {

    fun findAllByBookId(bookId: Int) =
        reviews.filter { it.bookId == bookId }

    fun createReview(review: Review): Review {
        reviews.add(review)
        return review
    }

    private val reviews: MutableList<Review> = mutableListOf()
}
