import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.4.31"
}

application.mainClassName = "com.yapoo.graphql.ApplicationKt"
group = "com.yapoo.graphql"
version = "0.0.1"

tasks.withType<KotlinCompile> {
    kotlinOptions {
        allWarningsAsErrors = true
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

repositories {
    jcenter()
    mavenCentral()
    maven("https://jitpack.io")
}

val ktor = "1.5.2"
val kotlin = "1.4.30"

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:$kotlin"))
    implementation(kotlin("stdlib", kotlin))
    implementation("io.ktor:ktor-server-core:$ktor")
    implementation("io.ktor:ktor-server-netty:$ktor")
    implementation("io.ktor:ktor-jackson:$ktor")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    implementation("com.graphql-java-kickstart:graphql-java-tools:11.0.0")
}
