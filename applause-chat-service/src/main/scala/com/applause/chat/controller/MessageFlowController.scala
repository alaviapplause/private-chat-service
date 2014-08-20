package com.applause.chat.controller

import com.applause.chat.dao.DbClient
import com.applause.chat.model.MessageEntity
import com.applause.chat.dao.MessageDataService
import scala.slick.driver.PostgresDriver
import com.pusher.rest.Pusher
import java.util.Collections

class MessageFlowController extends FlowController {

  override def run(): Boolean = {
    val client = new DbClient(PostgresDriver)
    		
    // create message in database
    val authorId = 1
    val topicId = 1
    val message = MessageDataService.createMessage(client, "hello lalala", authorId, topicId)
    
    // trigger event to Pusher
    val pusherUrl = "http://70eb0a60a430152a8099:d33b3b00f0e0c4842a10@api.pusherapp.com:80/apps/84864"
    val pusher = new Pusher(pusherUrl)
    pusher.setRequestTimeout(10000)
    
    // TODO get roomId from topic table or in API
    val roomId = 1
    pusher.trigger("muc-" + roomId, "message_added", Collections.singletonMap("message", message.text))
    
    println("Sent message " + message)
    true
  }
}