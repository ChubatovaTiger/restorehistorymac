package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with id = 'Project13_B1'
in the project with id = 'Project13', and delete the patch script.
*/
create(RelativeId("Project13"), BuildType({
    id("Project13_B1")
    name = "b1"
}))

