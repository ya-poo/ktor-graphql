package com.yapoo.graphql

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.SerializationFeature
import com.yapoo.graphql.web.GraphQLRequest
import com.yapoo.graphql.graphql.buildGraphQL
import com.yapoo.graphql.web.toResponse
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.slf4j.event.Level

fun main() {
    embeddedServer(
        factory = Netty,
        host = "0.0.0.0",
        port = 8080,
        module = { main() }
    ).start()
}

fun Application.main() {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
            setSerializationInclusion(JsonInclude.Include.NON_NULL)
        }
    }
    install(CallLogging) {
        level = Level.DEBUG
    }

    val graphQL = buildGraphQL()
    install(Routing) {
        route("graphql") {
            post {
                val request = call.receive<GraphQLRequest>()
                log.debug(request.query)
                val executionInput = request.toExecutionInput()
                val response = graphQL.execute(executionInput).toResponse()
                call.respond(HttpStatusCode.OK, response)
            }
        }
    }
}

