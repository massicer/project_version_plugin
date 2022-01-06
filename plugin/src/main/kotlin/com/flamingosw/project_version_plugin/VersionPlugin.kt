package com.flamingosw.project_version_plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.*

abstract class VersionPluginExtension (var propertiesFilePath: Property<String>? = null)

class VersionPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        val extension: VersionPluginExtension = project.extensions
            .create("versionPlugin", VersionPluginExtension::class.java)


        project.task("extract_version") {
            println("Using as properties file path: ${extension.propertiesFilePath}")
            extension.propertiesFilePath?.let { filePath ->
                val file = File(filePath.get())

                val prop = Properties()

                FileInputStream(file).use {
                    prop.load(it)
                    prop.setProperty("application.version", project.version as String?)

                    val out: OutputStream = FileOutputStream(file)
                    prop.store(out, "some comment")
                }
            }
        }

        project.task("build").finalizedBy("extract_version")

    }
}

