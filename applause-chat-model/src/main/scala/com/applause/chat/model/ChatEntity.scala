package com.applause.chat.model

import scala.slick.driver.PostgresDriver.simple._
import scala.slick.lifted.ProvenShape
import scala.slick.lifted.ForeignKeyQuery

abstract class ChatEntity(id: Int)

abstract class ChatTable[ChatEntity](tag: Tag, name: String)
	extends Table[ChatEntity](tag, name) {

  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  // TODO define createdAt as timestamp
  def createdAt = column[Long]("createdAt", O.NotNull)
  def isDeleted = column[Boolean]("isDeleted", O.NotNull)
  def deletedBy = column[Int]("deletedBy", O.NotNull)

  //def deletingUser: ForeignKeyQuery[User, (Int, Long, Boolean, Int, String, String)] =
  //  foreignKey("USER_FK", deletedBy, TableQuery[User])(_.id)
}