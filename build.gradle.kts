import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.federation.spike"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

plugins {
    id("org.springframework.boot") version "2.4.0-SNAPSHOT"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
    id("com.google.cloud.tools.jib") version "2.4.0"
}

allprojects {
    repositories {
        mavenCentral()
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://repo.spring.io/snapshot") }
    }
}

tasks.register("up") {
    doFirst {
        exec {
            workingDir = projectDir
            executable("./gradlew")
            args(":servicea:jibDockerBuild", ":serviceb:jibDockerBuild")
        }
    }
    doLast {
        exec {
            workingDir = projectDir
            executable("docker-compose")
            args("up", "--build")
        }
    }
}

subprojects {
    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}
