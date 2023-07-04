pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PhotoGrid"
include(":app")
include(":feature")
include(":core")
include(":core:data")
include(":core:domain")
include(":feature:photogrid")
include(":core:photonetwork")
include(":core:common")
