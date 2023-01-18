import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

version = "2022.10"

project {
buildType(build1changed3)
}

object build1changed3 : BuildType({
name = "b11"
    params {
        param("par", DslContext.getParameter(name = "par")))
    }
})
