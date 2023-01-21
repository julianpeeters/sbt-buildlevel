package sbtbuildlevel

import java.io.File

sealed trait BuildLevel
case object MetaBuild extends BuildLevel
case object MetaMetaBuild extends BuildLevel
case object MetaMetaMetaBuild extends BuildLevel
case object ProperBuild extends BuildLevel

object BuildLevel {
  
  def probeCurrent(baseDir: File): BuildLevel =
    baseDir.getPath().split("/").reverse.takeWhile(_ == "project") match {
      case Array()                                => ProperBuild
      case Array("project")                       => MetaBuild
      case Array("project", "project")            => MetaMetaBuild
      case Array("project", "project", "project") => MetaMetaMetaBuild
      case _ => sys.error("sbt-buildlevel expects only four build levels")
    }

}