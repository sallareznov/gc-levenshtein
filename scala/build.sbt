name := "levenshtein"

scalaVersion := "2.11.7"

sbtVersion := "0.13.9"

crossPaths := false

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
libraryDependencies += "junit" % "junit" % "4.10" % "test"

packAutoSettings
packTargetDir := new File("bin")