# Extract version Plugin
This Gradle plugin allows you to add your gradle project version to your `application.properties` file.

## How to use 
1. Add the plugin to your project
```kts
plugins {
    id("it.flamingosw.project_version_plugin") version "<CURRENT_VERSION>"
}
```
2. Create the properties file if it doesn't already exist
```shell
touch {your_project_path}/src/main/resources/application.properties
```

3. Execute the task
```shell
./gradlew extract_version        
```
