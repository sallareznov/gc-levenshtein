name := "levenshtein"
organization := "fil.iagl.opl.greencomputing.levenshtein"
scalaVersion := "2.11.7"
sbtVersion := "0.13.9"
mainClass in assembly := Some("fil.iagl.opl.greencomputing.levenshtein.Main")
assemblyJarName in assembly := "levenshtein.jar"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)