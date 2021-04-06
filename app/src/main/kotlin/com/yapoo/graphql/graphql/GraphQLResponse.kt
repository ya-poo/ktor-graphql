package com.yapoo.graphql.graphql

import graphql.ExecutionResult

data class GraphQLResponse(
    val data: Any? = null,
    val error: List<Any>? = null,
) {

    companion object {
        fun from(result: ExecutionResult) =
            GraphQLResponse(
                data = result.getData(),
                error = result.errors.takeIfNotEmpty()
            )

        private fun <T> List<T>.takeIfNotEmpty() =
            takeIf { it.isNotEmpty() }
    }
}

fun ExecutionResult.toResponse() = GraphQLResponse.from(this)
