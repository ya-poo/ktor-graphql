package com.yapoo.graphql.repository

import com.yapoo.graphql.domain.Author
import com.yapoo.graphql.domain.Country.Japan

class AuthorRepository {

    fun findById(authorId: Int) =
        records.singleOrNull { it.id == authorId }

    private val records: List<Author> = listOf(
        Author(1, "谷崎潤一郎", Japan),
        Author(2, "太宰治", Japan),
        Author(3, "安部公房", Japan),
    )
}
