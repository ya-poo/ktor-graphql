package com.yapoo.graphql

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.SerializationFeature
import com.yapoo.graphql.graphql.KtorGraphQLServer
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
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
        module = { main(KtorGraphQLServer()) }
    ).start()
}

fun Application.main(graphQL: KtorGraphQLServer) {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
            setSerializationInclusion(JsonInclude.Include.NON_NULL)
        }
    }
    install(CallLogging) {
        level = Level.DEBUG
    }

    install(Routing) {
        post("graphql") {
            val result = graphQL.execute(call.request)

            if (result != null) {
                call.respond(HttpStatusCode.OK, result)
            } else {
                call.respond(HttpStatusCode.BadRequest)
            }
        }
    }
}

