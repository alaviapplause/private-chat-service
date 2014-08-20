package com.applause.chat.model

import scala.slick.driver.PostgresDriver.simple._

case class LastReadEntity(userId: Int, topicId: Int, roomId: Option[Int] = None, lastRead: Long, messageSeqId: Int, id: Option[Int] = None)

class LastRead(tag: Tag) extends Table[LastReadEntity](tag, "LastRead") {
	
	def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
	def userId = column[Int]("userId", O.NotNull)
	def topicId = column[Int]("topicId", O.NotNull)
	def roomId = column[Int]("roomId")
	def lastRead = column[Long]("lastRead", O.NotNull)
	def messageSeqId = column[Int]("messageSeqId", O.NotNull)
	
	def * = (userId, topicId, roomId.?, lastRead, messageSeqId, id.?) <> (LastReadEntity.tupled, LastReadEntity.unapply)
	
	// TODO foreign keys
	//def user = foreignKey("Fk_User", userId, TableQuery[User])(_.id)
    //def room = foreignKey("Fk_Room", roomId, TableQuery[Room])(_.id)
	//def topic = foreignKey("Fk_Topic", topicId, TableQuery[Topic])(_.id)
}