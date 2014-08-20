name := "applause-chat-service"

version := "1.0"

scalaVersion := "2.11.2"

organization  := "com.applause"

libraryDependencies ++= List(
	"org.slf4j"           %   "slf4j-nop"    % "1.6.4",
	"com.pusher"		  %   "pusher-rest-java" % "0.9.0"
)