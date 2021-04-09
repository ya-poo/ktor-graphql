package com.yapoo.graphql.graphql

import com.yapoo.graphql.repository.AuthorRepository
import com.yapoo.graphql.repository.BookRepository
import com.yapoo.graphql.repository.ReviewRepository
import com.yapoo.graphql.resolver.*
import graphql.GraphQL
import graphql.kickstart.tools.SchemaParser

fun buildGraphQL(): GraphQL = GraphQL
    .newGraphQL(buildSchemaParser())
    .build()

private fun buildSchemaParser() = SchemaParser
    .newParser()
    .files(
        "query.graphql",
        "schema.graphql",
        "mutation.graphql",
    )
    .resolvers(
        QueryResolver(BookRepository()),
        BookResolver(AuthorRepository(), reviewRepository),
        AuthorResolver(),
        ReviewResolver(),
        MutationResolver(reviewRepository),
    )
    .build()
    .makeExecutableSchema()

private val reviewRepository = ReviewRepository()
