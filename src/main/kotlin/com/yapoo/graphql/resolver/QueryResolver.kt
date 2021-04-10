package com.yapoo.graphql.resolver

import com.yapoo.graphql.repository.BookRepository
import graphql.kickstart.tools.GraphQLQueryResolver

@Suppress("unused")
class QueryResolver(
    private val bookRepository: BookRepository
) : GraphQLQueryResolver {

    fun books() =
        bookRepository.findAll()

    fun book(id: Int) =
        bookRepository.findById(id)
}
