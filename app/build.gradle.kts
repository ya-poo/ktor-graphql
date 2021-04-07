plugins {
    application
    kotlin("jvm")
}

group = "com.yapoo.graphql"
version = "0.0.1"

application {
    mainClassName = "com.yapoo.graphql.ApplicationKt"
}

val ktor = "1.5.2"
val kotlin = "1.4.30"
val graphql = "11.0.0"
val logback = "1.2.3"

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:$kotlin"))
    implementation(kotlin("stdlib", kotlin))
    implementation("io.ktor:ktor-server-core:$ktor")
    implementation("io.ktor:ktor-server-netty:$ktor")
    implementation("io.ktor:ktor-jackson:$ktor")
    implementation("ch.qos.logback:logback-classic:$logback")

    implementation("com.graphql-java-kickstart:graphql-java-tools:$graphql")
}
