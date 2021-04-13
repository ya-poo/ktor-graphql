package com.yapoo.graphql.graphql

import com.expediagroup.graphql.server.execution.GraphQLServer
import io.ktor.request.*

class KtorGraphQLServer(
    requestParser: KtorGraphQLRequestParser = KtorGraphQLRequestParser(),
    contextFactory: KtorGraphQLContextFactory = KtorGraphQLContextFactory(),
    requestHandler: KtorGraphQLRequestHandler = KtorGraphQLRequestHandler()
) : GraphQLServer<ApplicationRequest>(requestParser, contextFactory, requestHandler)
