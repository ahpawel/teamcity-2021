package tests

import Amelinium_BuildLambdaLayer.buildTypes.Amelinium_BuildLambdaLayer_PublishLayer
import org.junit.Test
import jetbrains.buildServer.configs.kotlin.v10.*
import org.junit.Before


class TestUniqUuidExtId {
    var mainProjects: List<Project> = listOf(
            _Root.Project,
            Amelinium_BuildLambdaLayer.Project,
            Amelinium.Project)

    var projectList: MutableList<Project> = mutableListOf()
    var buildTypeList: MutableList<BuildType> = mutableListOf()
    var templatesList: MutableList<Template> = mutableListOf()
    var allExtIdList: MutableList<String> = mutableListOf()
    var allUUIDList: MutableList<String> = mutableListOf()

    fun addSubProjects(project: Project, indent: String = "") {
        println("${indent}Project - ${project.extId}")
        project.templates.forEach { tp ->
            println("${indent+"\t"}Template - ${tp.extId} - ${tp.uuid}")
            allExtIdList.add(tp.extId)
            allUUIDList.add(tp.uuid)
        }
        project.buildTypes.forEach { bt ->
            println("${indent+"\t"}BuildType - ${bt.extId} - ${bt.uuid}")
            allExtIdList.add(bt.extId)
            allUUIDList.add(bt.uuid)
        }
        project.subProjects.forEach { pt ->
            println("${indent+"\t"}SubProject - ${pt.extId} - ${pt.uuid}")
            projectList.add(pt)
            allExtIdList.add(pt.extId)
            allUUIDList.add(pt.uuid)
            addSubProjects(pt, indent+"\t")
        }
    }

    @Before
    fun addAllProjects(){
        mainProjects.forEach { pt ->
            addSubProjects(pt)
        }
    }

    @Test
    fun validateProjectsNames(){
        projectList.forEach { project ->
            val names: MutableSet<String> = mutableSetOf()
            project.buildTypes.forEach { bt ->
                if (names.contains(bt.name)) {
                    throw Exception("Already have build type of name '${bt.name}' in project '${project.name}'")
                } else {
                    names.add(bt.name)
                }
            }
            names.clear()
            project.templates.forEach { tp ->
                if (names.contains(tp.name)) {
                    throw Exception("Already have template of name '${tp.name}' in project '${project.name}'")
                } else {
                    names.add(tp.name)
                }
            }
            names.clear()
            project.subProjects.forEach { pt ->
                if (names.contains(pt.name)) {
                    throw Exception("Already have project of name '${pt.name}' in project '${project.name}'")
                } else {
                    names.add(pt.name)
                }
            }
        }
    }

    @Test
    fun validateUUIDs(){
        val uuidSet: MutableSet<String> = mutableSetOf()
        allUUIDList.forEach { uuid ->
            if (uuid in uuidSet) {
                throw Exception("Already used uuid ${uuid}")
            } else {
                uuidSet.add(uuid)
            }
            if (!uuid.matches(Regex("[a-zA-Z0-9_\\-]+"))) {
                throw Exception("Invalid uuid ${uuid}")
            }
        }
    }

    @Test
    fun validateProjects(){
        val extIdSet: MutableSet<String> = mutableSetOf()
        projectList.forEach { project ->
            if (project.extId in extIdSet) {
                throw Exception("Already used extId ${project.extId}")
            } else {
                extIdSet.add(project.extId)
            }
        }
    }


    @Test
    fun validateBuildTypes(){
        val extIdSet: MutableSet<String> = mutableSetOf()
        buildTypeList.forEach { buildType ->
            if (buildType.extId in extIdSet) {
                throw Exception("Already used extId ${buildType.extId}")
            } else {
                extIdSet.add(buildType.extId)
            }
        }
    }

    @Test
    fun validateTemplates(){
        val extIdSet: MutableSet<String> = mutableSetOf()
        templatesList.forEach { tp ->
            if (tp.extId in extIdSet) {
                throw Exception("Already used extId ${tp.extId}")
            } else {
                extIdSet.add(tp.extId)
            }
        }
    }
}
