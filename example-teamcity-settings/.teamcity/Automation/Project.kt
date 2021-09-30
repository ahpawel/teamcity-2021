package Automation

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project

object Project : Project({
    uuid = "1d7e2113-fb0b-423d-bba8-lkjalksdfas"
    extId = "Automation"
    parentId = "_Root"
    name = "Automation"
    description = "Top automation package"

    cleanup {
        preventDependencyCleanup = false
    }
})
