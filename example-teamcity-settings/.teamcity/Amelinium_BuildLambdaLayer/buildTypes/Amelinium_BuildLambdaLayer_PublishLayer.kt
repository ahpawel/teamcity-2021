package Amelinium_BuildLambdaLayer.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script

object Amelinium_BuildLambdaLayer_PublishLayer : Template({
    uuid = "aee667e9-d3c1-4740-be7b-fabc67615dc2"
    extId = "Amelinium_BuildLambdaLayer_PublishLayer"
    name = "Publish layer template"

    steps {
        script {
            name = "Build"
            id = "RUNNER_1"
            scriptContent = """echo "Bulding layer""""
        }
        script {
            name = "Upload"
            id = "RUNNER_2"
            scriptContent = """echo "Upload layer""""
        }
        script {
            name = "Publish layer"
            id = "RUNNER_3"
            scriptContent = """echo "Publish layer""""
        }
    }
})
