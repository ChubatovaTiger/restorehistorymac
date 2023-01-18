import jetbrains.buildServer.configs.kotlin.*

import jetbrains.buildServer.configs.kotlin.buildSteps.script



version = "2022.10"



project {




        buildType(B11x)


}



object B11x : BuildType({



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
