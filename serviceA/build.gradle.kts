plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}
dependencies {
    implementation("com.expediagroup:graphql-kotlin-spring-server:3.5.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}
