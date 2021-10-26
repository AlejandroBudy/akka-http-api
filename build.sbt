/** ********* PROJECT INFO ***************** */
name := "api"
version := "1.0"

val akka = "2.5.7"
val akkaHttp = "10.0.11"


/** ********* PROJECT SETTINGS ***************** */
Configuration.settings

/** ********* PROD DEPENDENCIES **************** */
libraryDependencies ++= Seq(
  "com.github.nscala-time" %% "nscala-time" % "2.22.0",
  "com.lihaoyi" %% "pprint" % "0.5.6",
  "com.typesafe.akka" %% "akka-http" % akkaHttp,
  "com.typesafe.akka" %% "akka-actor" % akka,
  "com.typesafe.akka" %% "akka-stream" % akka
)

/** ********* TEST DEPENDENCIES **************** */
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.4" % Test,
  "org.scalamock" %% "scalamock" % "4.4.0" % Test,
  "com.typesafe.akka" %% "akka-testkit" % akka % Test,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttp % Test
)

/** ********* COMMANDS ALIASES ***************** */
addCommandAlias("t", "test")
addCommandAlias("to", "testOnly")
addCommandAlias("tq", "testQuick")
addCommandAlias("tsf", "testShowFailed")

addCommandAlias("c", "compile")
addCommandAlias("tc", "test:compile")

addCommandAlias("f", "scalafmt") // Format production files according to ScalaFmt
addCommandAlias("fc", "scalafmtCheck") // Check if production files are formatted according to ScalaFmt
addCommandAlias("tf", "test:scalafmt") // Format test files according to ScalaFmt
addCommandAlias("tfc", "test:scalafmtCheck") // Check if test files are formatted according to ScalaFmt

// All the needed tasks before pushing to the repository (compile, compile test, format check in prod and test)
addCommandAlias("prep", ";c;tc;fc;tfc")
