package Amelinium.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object Amelinium_Teamcity2021 : GitVcsRoot({
    uuid = "8106f567-f219-444f-9311-e6b67bb1d5a3"
    extId = "Amelinium_Teamcity2021"
    name = "teamcity-2021"
    url = "https://github.com/ahpawel/teamcity-2021"
    branch = "refs/heads/main"
})
