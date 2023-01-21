ThisBuild / organization := "com.julianpeeters"
ThisBuild / scalaVersion := "2.12.17"
ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val proper = TaskKey[Unit]("proper") := {
  if (buildLevel.value == sbtbuildlevel.ProperBuild) ()
  else sys.error("unexpected result: " + buildLevel.value)
}

lazy val `plugin-test` = (project in file("."))
  .enablePlugins(sbtbuildlevel.Key)
  .settings(
    name := "plugin-test",
    proper,
  )