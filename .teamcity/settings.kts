import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

version = "2022.10"

project {

    if (DslContext.getParameter(name = "buildTypePresence") != "false" )
    {
        buildType(B11xx)
    }
}

object B11xx : BuildType({

    name = "b11"

    params {
        param("par", "2")
    }

    steps {
        script {
            id = "RUNNER_2"
            scriptContent = "sleep 12"
        }
    }
})
