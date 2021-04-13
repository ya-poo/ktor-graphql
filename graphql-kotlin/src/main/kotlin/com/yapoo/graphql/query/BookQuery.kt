package com.yapoo.graphql.query

import com.expediagroup.graphql.server.operations.Query
import com.yapoo.graphql.domain.Book

class BookQuery : Query {

    suspend fun books(): List<Book> =
        listOf(
            Book(1, "a", 1),
            Book(2, "b", 1),
            Book(3, "c", 1)
        )
}
