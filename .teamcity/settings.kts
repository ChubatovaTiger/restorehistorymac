import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

version = "2022.10"

project {
buildType(build1changed)
}

object build1changed : BuildType({
name = "b11"
    params {
        DslContext.getParameter(name = "par")
    }
})
