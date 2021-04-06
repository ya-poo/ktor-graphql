import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31" apply false
}

tasks.getByName<Wrapper>("wrapper") {
    gradleVersion = "6.6"
}

subprojects {
    repositories {
        jcenter()
        mavenCentral()
        maven("https://jitpack.io")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            allWarningsAsErrors = true
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}
