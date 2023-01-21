ThisBuild / organization := "com.julianpeeters"
ThisBuild / scalaVersion := "2.12.17"
ThisBuild / version := "0.1.0"
ThisBuild / versionScheme := Some("early-semver")

lazy val `sbt-buildlevel` = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "sbt-buildlevel",
    publishSettings,
    scriptedSettings
  )

lazy val scriptedSettings =
  Seq(
    scriptedLaunchOpts := { scriptedLaunchOpts.value ++
      Seq("-Xmx1024M", "-Dplugin.version=" + version.value),
    },
    scriptedBufferLog := false,
  )

lazy val publishSettings =
  Seq(
    licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    homepage := Some(url(s"https://github.com/julianpeeters/sbt-buildlevel")),
    publishMavenStyle := true,
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (version.value.trim.endsWith("SNAPSHOT"))
      Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
      },
    pomIncludeRepository := { _ => false },
    pomExtra := (
      <scm>
      <url>git://github.com/julianpeeters/sbt-buildlevel.git</url>
      <connection>scm:git://github.com/julianpeeters/sbt-buildlevel.git</connection>
      </scm>
      <developers>
      <developer>
      <id>julianpeeters</id>
      <name>Julian Peeters</name>
      <url>http://github.com/julianpeeters</url>
      </developer>
      </developers>)
    ,
    Test / publishArtifact := false
  )