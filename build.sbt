name := "scalafx-ensemble"

version := "1.0-SNAPSHOT"

organization := "org.scalafx"

scalaVersion := "2.11.2"

assemblySettings

libraryDependencies ++= Seq(
  "org.scalafx"            %% "scalafx" % "2.2.67-R10",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
)

resolvers += Opts.resolver.sonatypeSnapshots

scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xlint")

// Sources should also be copied to output, so the sample code, for the viewer,
// can be loaded from the same file that is used to execute the example
unmanagedResourceDirectories in Compile <+= baseDirectory { _/"src/main/scala"}

// Set the prompt (for this build) to include the project id.
shellPrompt := { state => System.getProperty("user.name") + ":" + Project.extract(state).currentRef.project + "> " }

// Add JavaFX 2.0 to classpath
unmanagedJars in Compile += Attributed.blank(file(scala.util.Properties.javaHome + "/lib/jfxrt.jar"))

// Run in separate VM, so there are no issues with double initialization of JavaFX
fork := true

fork in Test := true
