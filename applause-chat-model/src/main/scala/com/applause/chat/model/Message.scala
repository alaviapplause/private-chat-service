package com.applause.chat.model

import scala.slick.driver.PostgresDriver.simple._

case class MessageEntity(text: String, authorId: Int, messageSeqId: Int, topicId: Int, isHighlighted: Option[Boolean] = Some(false), id: Option[Int] = None) {
//	val createdAt = System.currentTimeMillis() 
}

class Message(tag: Tag) extends Table[MessageEntity](tag, "Message") {
	
	def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
	def text = column[String]("text", O.NotNull)
	def authorId = column[Int]("authorId", O.NotNull)
	def messageSeqId = column[Int]("messageSeqId", O.NotNull)
	def isHighlighted = column[Boolean]("isHighlighted", O.NotNull)
	def topicId = column[Int]("topicId", O.NotNull)
		
	def * = (text, authorId, messageSeqId, topicId, isHighlighted.?, id.?) <> (MessageEntity.tupled, MessageEntity.unapply)
	// TODO figure out the best approach to define foreign keys
	//def topic = foreignKey("Fk_Topic", topicId, TableQuery[Topic])(_.id)
	
	//def author = foreignKey("Fk_Author", authorId, TableQuery[User])(_.id)
}
 