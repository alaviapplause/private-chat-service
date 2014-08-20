package com.applause.chat.model

import scala.slick.driver.PostgresDriver.simple._

case class UserContactEntity(userId: Int, contactId: Int, id: Option[Int] = None)

class UserContact(tag: Tag) extends Table[UserContactEntity](tag, "UserContact") {
  
	def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
	def userId = column[Int]("userId", O.NotNull)
	def contactId = column[Int]("contactId", O.NotNull)
	
	def * = (userId, contactId, id.?) <> (UserContactEntity.tupled, UserContactEntity.unapply)
	
	// TODO foreign keys
	//def user = foreignKey("Fk_User", userId, TableQuery[User])(_.id)
    //def contact = foreignKey("Fk_Contact", contactId, TableQuery[User])(_.id)
}
/*
class UserContact(tag: Tag)
  extends Table[(Int, Int)](tag, "UserContacts") {

  def userId: Column[Int] = column("userId", O.NotNull)
  def contactId: Column[Int] = column("contactId", O.NotNull)

  def * : ProvenShape[(Int, Int)] = (userId, contactId)

  def user: ForeignKeyQuery[User, (Int, Long, Boolean, Int, String, String)] =
    foreignKey("USER_FK", userId, TableQuery[User])(_.id)

  def contact: ForeignKeyQuery[User, (Int, Long, Boolean, Int, String, String)] =
    foreignKey("CONTACT_FK", contactId, TableQuery[User])(_.id)

  // TODO define primary key as userId + contactId
}
*/