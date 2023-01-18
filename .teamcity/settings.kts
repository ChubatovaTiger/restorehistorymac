import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

version = "2022.10"

project {

    if (DslContext.getParameter(name = "buildTypePresence") != "false" )
    {
        buildType(B11)
    }
}

object B11 : BuildType({
    templates(AbsoluteId("Project1_B1_2"))
    name = "b11"

    params {
        param("par", DslContext.getParameter(name = "par"))
    }

    steps {
        script {
            id = "RUNNER_2"
            scriptContent = "sleep 12"
        }
    }
})
