package com.applause.chat.controller

trait FlowController {

  def run(): Boolean = {
    println("Start flow")
    
    // authenticate user
    val userAuthenticated = true
    if (userAuthenticated) {
      println("user authenticated") 
    }
    else {
      println("Unauthorized user")
    }
    
    userAuthenticated
  }
}