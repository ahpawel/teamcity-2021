package Amelinium_BuildLambdaLayer.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script

object Amelinium_BuildLambdaLayer_OnStaging : BuildType({
    uuid = "8c6da129-b48a-424c-b422-f5893a05b2d6"
    extId = "Amelinium_BuildLambdaLayer_OnStaging"
    name = "On staging"

    steps {
        script {
            name = "Step only on build"
            scriptContent = """echo "Step only on build not based on template""""
        }
    }
})
