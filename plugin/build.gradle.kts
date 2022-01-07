group = "io.github.massicer"
version = "0.1.0"

plugins {
    `java-gradle-plugin`
    kotlin("jvm") version "1.6.10"
    id("maven-publish")
    id("com.gradle.plugin-publish") version "0.19.0"
    id("org.jlleitschuh.gradle.ktlint") version "10.2.1"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib", "1.6.10"))
    testImplementation(kotlin("test"))
    testImplementation(platform("io.kotest:kotest-bom:5.0.3"))
    testImplementation("io.kotest", "kotest-assertions-core")
}

tasks.test {
    useJUnitPlatform()
}

pluginBundle {
    website = "https://github.com/massicer/project_version_plugin"
    vcsUrl = "https://github.com/massicer/project_version_plugin"
    tags = listOf("version", "properties")
}

gradlePlugin {
    plugins {
        create("project_version_plugin") {
            id = "io.github.massicer.project_version_plugin"
            implementationClass = "io.github.massicer.project_version_plugin.VersionPlugin"
            displayName = "Extract version plugin"
            description = "Extract your gradle project version writing it in the `application.properties` file."
        }
    }
}
