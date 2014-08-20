package com.applause.chat.model

import scala.slick.driver.PostgresDriver.simple._

case class TopicEntity(name: String, status: String, roomId: Int, id: Option[Int] = None) {
	val createdAt = System.currentTimeMillis()
}

class Topic(tag: Tag) extends Table[TopicEntity](tag, "Topic") {
	def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
	def name = column[String]("topicName", O.NotNull)
	def status = column[String]("status", O.NotNull)
	def roomId = column[Int]("roomId", O.NotNull)
	
	def * = (name, status, roomId, id.?) <> (TopicEntity.tupled, TopicEntity.unapply)
	// TODO figure out the best approach to define foreign keys
	//def room = foreignKey("Fk_Room", roomId, TableQuery[Room])(_.id)
}
