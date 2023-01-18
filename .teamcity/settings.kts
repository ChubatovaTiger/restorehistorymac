import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.schedule
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

    buildType(B11)
    buildType(B21)

    template(B1_2)
    template(B2_2)
}

object B11 : BuildType({
    templates(B1_2)
    name = "b11"
})

object B21 : BuildType({
    templates(B2_2)
    name = "b21"
})

object B1_2 : Template({
    name = "b1"

    params {
        param("b1", "1")
    }

    steps {
        script {
            id = "RUNNER_2"
            scriptContent = "echo b1"
        }
    }

    triggers {
        vcs {
            id = "TRIGGER_2"
            triggerRules = "+:comment=ghgh:**"
            branchFilter = ""
        }
    }
})

object B2_2 : Template({
    name = "b2"

    params {
        param("b2", "2")
    }

    steps {
        script {
            id = "RUNNER_3"
            scriptContent = "echo b2"
        }
    }

    triggers {
        schedule {
            id = "TRIGGER_3"
            branchFilter = ""
            triggerBuild = always()
        }
    }
})
