name := "applause-chat-model"

version := "1.0"

scalaVersion := "2.11.2"

organization  := "com.applause"

libraryDependencies ++= List(
	"com.typesafe.slick" %% "slick" % "2.1.0" withSources() withJavadoc(),
	"org.slf4j"           %   "slf4j-nop"    % "1.6.4",
	"postgresql"           %  "postgresql"   % "9.1-901-1.jdbc4"
)