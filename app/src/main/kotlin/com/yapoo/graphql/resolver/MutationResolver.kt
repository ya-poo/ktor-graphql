package com.yapoo.graphql.resolver

import com.yapoo.graphql.domain.Review
import com.yapoo.graphql.repository.ReviewRepository
import graphql.kickstart.tools.GraphQLMutationResolver
import kotlin.random.Random

class MutationResolver(
    private val reviewRepository: ReviewRepository
) : GraphQLMutationResolver {

    fun submitReview(
        bookId: Int,
        stars: Int,
        commentary: String
    ): Review {
        return reviewRepository.createReview(
            Review(
                id = Random.nextInt(),
                bookId = bookId,
                stars = stars,
                commentary = commentary
            )
        )
    }
}
