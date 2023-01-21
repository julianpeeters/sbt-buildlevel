# sbt-buildlevel
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