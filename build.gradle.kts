plugins {
    java
    id("nu.studer.jooq") version "8.0" apply false
}

allprojects {
    group = "ru.mail"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

val jooqVersion = "3.17.4"

subprojects {
    apply(plugin = "java")

    apply {
        plugin("nu.studer.jooq")
    }
    dependencies {
        implementation("org.jooq:jooq:$jooqVersion")
        implementation("org.jooq:jooq-codegen:$jooqVersion")
        implementation("org.jooq:jooq-meta:$jooqVersion")
        implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")


        implementation("org.jetbrains:annotations:20.1.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}