package com.yapoo.graphql.resolver

import com.yapoo.graphql.domain.Author
import graphql.kickstart.tools.GraphQLResolver

@Suppress("unused")
class AuthorResolver : GraphQLResolver<Author> {

    fun country(author: Author) = author.country

}
