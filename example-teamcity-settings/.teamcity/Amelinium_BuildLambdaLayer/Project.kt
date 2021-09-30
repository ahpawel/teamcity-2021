package Amelinium_BuildLambdaLayer

import Amelinium.vcsRoots.*
import Amelinium_BuildLambdaLayer.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script

fun generateBuildType(environment: String): BuildType {
    return BuildType({
        uuid = "07cc80a2-a30b-49e0-86a1-671be6484441-$environment"
        extId = "Amelinium_BuildLambdaLayer_BuildFor$environment"
        name = "Build Chrome Layer for $environment"

        val lambdaDirectory = "lambda"
        val lambdaLayerDirectory = "lambda/layers"

        vcs {
            root(Amelinium_AirHelp, "+:. => $lambdaDirectory")
            cleanCheckout = true
        }

        steps {
            script {
                name = "Check before runnings scripts $environment"
                id = "PREREQUISITES_CHECK"
                workingDir = lambdaLayerDirectory
                scriptContent = """
                    echo "....... Execution of build.sh" > build.sh
                    echo "....... Execution of upload.sh" > upload.sh
                    echo "....... Execution of download.sh" > download.sh
                    echo "....... Execution of publish.sh" > publish.sh

                    chmod +x build.sh
                    chmod +x upload.sh
                    chmod +x download.sh
                    chmod +x publish.sh
                    
                    ls -la *
                """.trimIndent()
            }
            if (environment != "production") {
                script {
                    name = "Build layer on $environment"
                    id = "BUILD_LAYER"
                    workingDir = lambdaLayerDirectory
                    scriptContent = """
                        ls -la *
                        ./build_layer.sh
                    """
                }
                script {
                    name = "Upload layer on $environment"
                    id = "UPLOAD_LAYER"
                    workingDir = lambdaLayerDirectory
                    scriptContent = "./upload_layer.sh"
                }
            } else {
                script {
                    name = "Download layer on $environment"
                    id = "DOWNLOAD_LAYER"
                    workingDir = lambdaLayerDirectory
                    scriptContent = "./download_layer.sh"
                }
            }
            script {
                name = "Publish layer on $environment"
                id = "PUBLISH_LAYER"
                workingDir = lambdaLayerDirectory
                scriptContent = "./publish_layer.sh $environment"
            }
        }

        cleanup {
            artifacts(builds = 10, days = 10)
            preventDependencyCleanup = false
        }
    })
}

object Project : Project({
    uuid = "d5a081c7-4923-449e-8aa5-29a9028eda59"
    extId = "Amelinium_BuildLambdaLayer"
    parentId = "Amelinium"
    name = "Build Lambda Layer Subproject"

    buildType(Amelinium_BuildLambdaLayer_OnStaging)
    buildType(Amelinium_BuildLambdaLayer_SecondConfigurationBasedOnTemplate)
    buildType(generateBuildType("sta"))
    buildType(generateBuildType("production"))

    template(Amelinium_BuildLambdaLayer_PublishLayer)
})
