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
        maven("https://jitpack.io")
    }
}

//inner modules
rootProject.name = "The Republic of IT"
include(":app")
include(":google")
include(":google:guide")

//external modules
val parentPath = "../TheRepublicofLibs"
val modules = arrayOf(
    ":core-common"
)
if (modules.isNotEmpty()){
    for (name in modules){
        include(name)
        project(name).projectDir = File(settingsDir,parentPath+"/"+name.substring(1,name.length))
    }
}
include(":ui")
include(":ui:home")
include(":ui:community")
include(":ui:message")
include(":ui:my")
