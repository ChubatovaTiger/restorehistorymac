import jetbrains.buildServer.configs.kotlin.*

import jetbrains.buildServer.configs.kotlin.buildSteps.script



version = "2022.10"



project {




        buildType(B11xv)


}



object B11xv : BuildType({



    name = "b11"



    params {

        param("par", "1")

    }



    steps {

        script {

            id = "RUNNER_2"

            scriptContent = "sleep 12"

        }

    }

})
