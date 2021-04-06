package com.yapoo.graphql.graphql

import graphql.ExecutionInput

data class GraphQLRequest(
    val query: String,
    val operationName: String? = null,
    val variables: Map<String, Any> = emptyMap()
) {

    fun toExecutionInput(): ExecutionInput =
        ExecutionInput
            .Builder()
            .apply {
                query(query)
                operationName(operationName)
                variables(variables)
            }.build()
}
