# sbt-buildlevel [![Scala CI](https://github.com/actions/setup-java/actions/workflows/ci.yml/badge.svg)](https://github.com/actions/setup-java/actions/workflows/ci.yml) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.julianpeeters/sbt-buildlevel/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.julianpeeters/sbt-buildlevel)
Which build is currently loaded, meta-build or proper build?

This is a library for sbt plugins, particularly global sbt plugins:
 - load different settings and tasks, according to build level
 - load the same settings and tasks, regardless of build level

## Install the library
Add the dependency to `$BASE_DIR/build.sbt` of a plugin:

```scala
lazy val myplugin = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    addSbtPlugin("com.julianpeeters" % "sbt-buildlevel" % SbtBuildLevelV),
    ...
```

## Use the library
Import the setting key in a plugin:

```scala
import sbt._
import sbtbuildlevel.Key.autoImport.buildLevel 
import sbtbuildlevel.ProperBuild

object MyPlugin extends AutoPlugin {
  if (buildlevel.value == ProperBuild) ...
  else ...
```