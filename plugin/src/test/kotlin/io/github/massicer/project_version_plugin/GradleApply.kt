package io.github.massicer.project_version_plugin

import io.kotest.matchers.shouldNotBe
import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test

class GradleApply {

    @Test
    fun `Using the Plugin ID should apply the plugin`() {
        val project = ProjectBuilder.builder().build()

        project.pluginManager.apply("io.github.massicer.project_version_plugin")

        project.plugins.getPlugin(VersionPlugin::class.java) shouldNotBe null
    }
}
