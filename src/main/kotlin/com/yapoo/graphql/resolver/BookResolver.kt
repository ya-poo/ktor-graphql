package com.yapoo.graphql.resolver

import com.yapoo.graphql.domain.Book
import com.yapoo.graphql.repository.AuthorRepository
import com.yapoo.graphql.repository.ReviewRepository
import graphql.kickstart.tools.GraphQLResolver

@Suppress("unused")
class BookResolver(
    private val authorRepository: AuthorRepository,
    private val reviewRepository: ReviewRepository
) : GraphQLResolver<Book> {

    fun author(book: Book) =
        authorRepository.findById(book.authorId)

    fun reviews(book: Book) =
        reviewRepository.findAllByBookId(book.id)

}
