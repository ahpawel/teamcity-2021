package Amelinium_BuildLambdaLayer.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script

object Amelinium_BuildLambdaLayer_SecondConfigurationBasedOnTemplate : BuildType({
    template(Amelinium_BuildLambdaLayer.buildTypes.Amelinium_BuildLambdaLayer_PublishLayer)
    uuid = "07cc80a2-a30b-49e0-86a1-671be6484441"
    extId = "Amelinium_BuildLambdaLayer_SecondConfigurationBasedOnTemplate"
    name = "Second Configuration based on template"

    steps {
        script {
            name = "Staging publish"
            id = "RUNNER_4"
            scriptContent = """echo "Staging only build""""
        }
        stepsOrder = arrayListOf("RUNNER_1", "RUNNER_2", "RUNNER_3", "RUNNER_4")
    }
})
