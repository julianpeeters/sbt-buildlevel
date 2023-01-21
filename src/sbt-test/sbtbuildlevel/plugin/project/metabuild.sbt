lazy val meta = TaskKey[Unit]("meta") := {
  if (buildLevel.value == sbtbuildlevel.MetaBuild) ()
  else sys.error("unexpected result: " + buildLevel.value)
}
lazy val `plugin-test` = (project in file("."))
  .enablePlugins(sbtbuildlevel.Key)
  .settings(
    name := "plugin-test",
    meta
  )