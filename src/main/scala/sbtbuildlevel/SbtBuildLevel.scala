package sbtbuildlevel

import sbt.{AutoPlugin, Def, Plugins, PluginTrigger, SettingKey, ThisBuild}
import sbt.Keys.baseDirectory

object Key extends AutoPlugin {

  object autoImport {

    lazy val buildLevel: SettingKey[BuildLevel] =
      sbt.settingKey[BuildLevel]("The currently loaded build")
      
  }

  import autoImport._

  override def requires: Plugins =
    sbt.plugins.JvmPlugin

  override def trigger: PluginTrigger =
    allRequirements

  override lazy val buildSettings: Seq[Def.Setting[_]] =
    buildLevelSettings

  lazy val buildLevelSettings: Seq[Def.Setting[_]] =
    Seq(
      ThisBuild / buildLevel := BuildLevel.probeCurrent(baseDirectory.value)
    )

}