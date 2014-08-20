package com.applause.chat.dao

import scala.slick.lifted.TableQuery
import com.applause.chat.model.Message
import com.applause.chat.model.MessageEntity
import scala.slick.driver.PostgresDriver.simple._

trait MessageDao {

	val messageTable = TableQuery[Message]
	
	private val messageAutoInc =
    	messageTable.map(m => (m.text, m.authorId, m.messageSeqId, m.isHighlighted, m.topicId)) returning messageTable.map(_.id)
    
	def insert(message: MessageEntity)(implicit session: Session): MessageEntity = {
		println("Insert new message:" + message)
		val id = messageAutoInc.insert(message.text, message.authorId, message.messageSeqId, message.isHighlighted.get, message.topicId)
		message.copy(text = message.text, authorId = message.authorId, messageSeqId = message.messageSeqId, isHighlighted = message.isHighlighted, topicId = message.topicId, id = Option(id))
	}
}

object MessageDataService {
	
  def createMessage(client: DbClient, text:String, authorId: Int, topicId: Int): MessageEntity = {
    
	  client.db withSession { implicit session =>
		  val messageTable = TableQuery[Message]
		  val msgSeqId = 10; // TODO get last seqId from topic table and increment it by 1
		  
		  val message = client.insert(MessageEntity(text, authorId, msgSeqId, topicId))
		  println("Created message " + message.id)
		  message
	  }
		
  }
  
}