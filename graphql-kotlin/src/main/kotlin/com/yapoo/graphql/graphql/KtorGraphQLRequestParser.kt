package com.yapoo.graphql.graphql

import com.expediagroup.graphql.server.execution.GraphQLRequestParser
import com.expediagroup.graphql.server.types.GraphQLServerRequest
import io.ktor.request.*

class KtorGraphQLRequestParser : GraphQLRequestParser<ApplicationRequest> {

    override suspend fun parseRequest(
        request: ApplicationRequest
    ): GraphQLServerRequest {
        return request.call.receive()
    }
}
