package com.yapoo.graphql.resolver

import com.yapoo.graphql.repository.BookRepository
import graphql.kickstart.tools.GraphQLQueryResolver

@Suppress("unused")
class QueryResolver(
    private val bookRepository: BookRepository
) : GraphQLQueryResolver {

    suspend fun books() =
        bookRepository.findAll()
}
