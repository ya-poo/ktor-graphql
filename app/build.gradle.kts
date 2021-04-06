plugins {
    application
    kotlin("jvm")
}

group = "com.yapoo.graphql"
version = "0.0.1"

application {
    mainClassName = "com.yapoo.graphql.ApplicationKt"
}

object Versions {
    const val ktor = "1.5.2"
    const val kotlin = "1.4.30"
    const val graphql = "11.0.0"
    const val logback = "1.2.3"
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:${Versions.kotlin}"))
    implementation(kotlin("stdlib", Versions.kotlin))
    implementation("io.ktor:ktor-server-core:${Versions.ktor}")
    implementation("io.ktor:ktor-server-netty:${Versions.ktor}")
    implementation("io.ktor:ktor-jackson:${Versions.ktor}")
    implementation("ch.qos.logback:logback-classic:${Versions.logback}")

    implementation("com.graphql-java-kickstart:graphql-java-tools:${Versions.graphql}")
}
