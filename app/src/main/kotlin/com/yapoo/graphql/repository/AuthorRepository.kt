package com.yapoo.graphql.repository

import com.yapoo.graphql.domain.Author

class AuthorRepository {

    suspend fun findById(authorId: Int) =
        records.singleOrNull { it.id == authorId }

    private val records: List<Author> = listOf(
        Author(1, "谷崎潤一郎"),
        Author(2, "太宰治"),
        Author(3, "安部公房"),
    )
}
