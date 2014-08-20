package com.applause.chat.dao

import scala.slick.lifted.TableQuery
import com.applause.chat.model.Message
import com.applause.chat.model.MessageEntity
import scala.slick.driver.PostgresDriver.simple._
import com.typesafe.scalalogging.LazyLogging

class MessageDao(client: DbClient) extends LazyLogging {

  def createMessage(text: String, authorId: Int, topicId: Int): MessageEntity = {

    // TODO add connection pooling
    client.db withSession { implicit session =>
      val msgSeqId = 10; // TODO get last seqId from topic table and increment it by 1

      val message = create(MessageEntity(text, authorId, msgSeqId, topicId))
      logger.debug("Created message {}", message)
      println("Created message " + message)
      message
    }
  }
  
  private val messageTable = TableQuery[Message]
  private val messageAutoInc =
    messageTable.map(m => (m.text, m.authorId, m.messageSeqId, m.topicId, m.isHighlighted)) returning messageTable.map(_.id)

  private def create(message: MessageEntity)(implicit session: Session): MessageEntity = {
    println("Create new message:" + message)
    // insert to DB
    val id = messageAutoInc.insert(message.text, message.authorId, message.messageSeqId, message.topicId, message.isHighlighted.get)
    // create return value
    message.copy(text = message.text, authorId = message.authorId, messageSeqId = message.messageSeqId,  
        		topicId = message.topicId, isHighlighted = message.isHighlighted, id = Option(id))
  }
  
  def ddl = messageTable.ddl
}

object MessageDao {
  def apply(client: DbClient): MessageDao = new MessageDao(client)
}