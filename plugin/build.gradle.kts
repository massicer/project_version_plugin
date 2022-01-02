group = "com.flamingosw"

plugins {
    `java-gradle-plugin`
    kotlin("jvm") version "1.6.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib", "1.6.10"))
    testImplementation(kotlin("test"))
    testImplementation(platform("io.kotest:kotest-bom:5.0.3"))
    testImplementation("io.kotest", "kotest-assertions-core")}

tasks.test {
    useJUnitPlatform()
}


gradlePlugin {
    plugins {
        create("project_version_plugin") {
            id = "com.flamingosw.project_version_plugin"
            implementationClass = "com.flamingosw.project_version_plugin.VersionPlugin"
        }
    }
}
