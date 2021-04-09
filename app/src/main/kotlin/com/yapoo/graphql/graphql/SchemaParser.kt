package com.yapoo.graphql.graphql

import com.yapoo.graphql.repository.AuthorRepository
import com.yapoo.graphql.repository.BookRepository
import com.yapoo.graphql.repository.ReviewRepository
import com.yapoo.graphql.resolver.AuthorResolver
import com.yapoo.graphql.resolver.BookResolver
import com.yapoo.graphql.resolver.QueryResolver
import graphql.GraphQL
import graphql.kickstart.tools.SchemaParser

fun buildGraphQL(): GraphQL = GraphQL
    .newGraphQL(buildSchemaParser())
    .build()

private fun buildSchemaParser() = SchemaParser
    .newParser()
    .files(
        "query.graphql",
        "schema.graphql"
    )
    .resolvers(
        QueryResolver(BookRepository()),
        BookResolver(AuthorRepository(), ReviewRepository()),
        AuthorResolver(),
    )
    .build()
    .makeExecutableSchema()
