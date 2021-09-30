package Amelinium

import Amelinium.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project

object Project : Project({
    uuid = "1d7e2113-fb0b-423d-1233-lkjalksdfas"
    extId = "Amelinium"
    parentId = "_Root"
    name = "Amelinium"
    description = "Amelinium automation"

    vcsRoot(Amelinium_AirHelp)

    cleanup {
        preventDependencyCleanup = false
    }
})
