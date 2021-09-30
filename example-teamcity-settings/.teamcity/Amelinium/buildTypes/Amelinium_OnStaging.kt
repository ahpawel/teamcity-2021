package Amelinium.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*

object Amelinium_OnStaging : BuildType({
    uuid = "c462765d-f4c4-4624-923f-ebb914aebaef"
    extId = "Amelinium_OnStaging"
    name = "On staging"

    vcs {
        root(Amelinium.vcsRoots.Amelinium_Teamcity2021)

    }
})
