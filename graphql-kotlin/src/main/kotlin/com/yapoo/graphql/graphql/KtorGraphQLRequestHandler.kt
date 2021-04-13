package com.yapoo.graphql.graphql

import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.toSchema
import com.expediagroup.graphql.server.execution.GraphQLRequestHandler
import graphql.GraphQL

class KtorGraphQLRequestHandler(
    graphQL: GraphQL = createGraphQL()
) : GraphQLRequestHandler(graphQL)

private fun createGraphQL(): GraphQL = GraphQL.newGraphQL(
    buildGraphQLSchema()
).build()

private fun buildGraphQLSchema() =
    toSchema(config, queries, mutations)

private val config = SchemaGeneratorConfig(supportedPackages = listOf("com.expediagroup.graphql.examples.server.ktor"))

private val queries = listOf<TopLevelObject>()

private val mutations = listOf<TopLevelObject>()
