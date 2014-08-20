package com.applause.chat.controller

object ControllerApp extends App {

    println("Running Controller App")
    
    val msgFlowCtrl = new MessageFlowController
    msgFlowCtrl.run
    
    println("Finished sending message")
}