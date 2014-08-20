	name := "applause-chat"
	
	version := "1.0"
	
	scalaVersion := "2.11.2"
	
	organization  := "com.applause"
	
	lazy val applauseChat = (project in file (".")).aggregate(applauseChatModel, applauseChatService)
	
	lazy val applauseChatModel = project in file ("applause-chat-model")

	lazy val applauseChatService = (project in file ("applause-chat-service")).dependsOn(applauseChatModel)
	
	
