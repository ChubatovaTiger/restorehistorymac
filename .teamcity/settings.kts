import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.parallelTests
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2022.10"

project {

    subProject(Project11)
    subProject(Project12)
}


object Project11 : Project({
    name = "project11"

    buildType(a_Build2)
    buildType(build3)
    buildType(Project11_Build1xx)
})

object Project11_Build1xx : BuildType({
    name = "build1"

    triggers {
        vcs {
            triggerRules = "+:comment=kjhkjhkj:**"
            branchFilter = ""
        }
    }

    features {
        parallelTests {
            numberOfBatches = 2
        }
    }
})

object a_Build2 : BuildType({
    name = "build2"

    steps {
        script {
            scriptContent = "ls"
        }
    }
})


object build3 : BuildType({
    name = "build3"

    steps {
        script {
            scriptContent = "ls"
        }
    }
})



object Project12 : Project({
    name = "project12"

    buildType(Project12_Build1)
    buildType(Project12_Build1copy)
})

object Project12_Build1 : BuildType({
    name = "build1"

    params {
        param("pr1build1", "echo pr1build1")
    }

    steps {
        script {
            scriptContent = "echo pr1build1"
        }
    }
})

object Project12_Build1copy : BuildType({
    name = "build1copy"

    params {
        param("pr1build1", "echo pr1build1")
    }

    steps {
        script {
            scriptContent = "echo pr1build1"
        }
    }
})
