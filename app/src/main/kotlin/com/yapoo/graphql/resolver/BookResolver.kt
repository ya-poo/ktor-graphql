package com.yapoo.graphql.resolver

import com.yapoo.graphql.domain.Book
import com.yapoo.graphql.repository.AuthorRepository
import graphql.kickstart.tools.GraphQLResolver

class BookResolver(
    private val authorRepository: AuthorRepository
) : GraphQLResolver<Book> {

    suspend fun author(book: Book) =
        authorRepository.findById(book.authorId)
}
