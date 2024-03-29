import Dependencies._

ThisBuild / scalaVersion     := "2.13.0"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.kazmiy"

scalacOptions ++= "-deprecation" :: "-feature" :: "-Xlint" :: Nil
scalacOptions in (Compile, console) ~= {_.filterNot(_ == "-Xlint")}

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := "cafe-backend",
    libraryDependencies += guice,
    libraryDependencies += scalaTestPlusPlay % Test,
    libraryDependencies += cats,
    libraryDependencies ++= circe,
    libraryDependencies += mysql,
    libraryDependencies ++= scalikejdbc,
    libraryDependencies += springSecurityWeb,
  )
