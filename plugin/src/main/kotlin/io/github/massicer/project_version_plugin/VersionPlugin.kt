package io.github.massicer.project_version_plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.Properties

class VersionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.task("extract_version") {
            project.gradle.projectsEvaluated {
                val propertiesFilePath = "${project.projectDir}/src/main/resources/application.properties"
                val file = File(propertiesFilePath)

                if (file.exists()) {
                    val prop = Properties()

                    FileInputStream(file).use {
                        prop.load(it)
                        prop.setProperty("application.version", project.version.toString())

                        val out: OutputStream = FileOutputStream(file)
                        prop.store(out, "Extracted from gradle")
                    }
                }
            }
        }
    }
}
