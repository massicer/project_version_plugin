package com.flamingosw.project_version_plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class VersionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("extract_version") {
            println("Hello from the VersionPlugin")
        }

        project.task("build").finalizedBy("extract_version")

    }
}

