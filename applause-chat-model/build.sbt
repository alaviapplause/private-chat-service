name := "applause-chat-model"

version := "1.0"

scalaVersion := "2.11.2"

organization  := "com.applause"

libraryDependencies ++= List(
	"com.typesafe.slick" %% "slick" % "2.1.0" withSources() withJavadoc(),
	"com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
	"postgresql"           %  "postgresql"   % "9.1-901-1.jdbc4"
)