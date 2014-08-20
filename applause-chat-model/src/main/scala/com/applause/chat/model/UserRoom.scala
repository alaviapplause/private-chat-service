package com.applause.chat.model

import scala.slick.driver.PostgresDriver.simple._

case class UserRoomEntity(userId: Int, roomId: Int, id: Option[Int] = None)

class UserRoom(tag: Tag) extends Table[UserRoomEntity](tag, "UserRoom") {
  
	def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
	def userId = column[Int]("userId", O.NotNull)
	def roomId = column[Int]("roomId", O.NotNull)
	
	def * = (userId, roomId, id.?) <> (UserRoomEntity.tupled, UserRoomEntity.unapply)
	
	// TODO foreign keys
	//def user = foreignKey("Fk_User", userId, TableQuery[User])(_.id)
    //def room = foreignKey("Fk_Room", roomId, TableQuery[Room])(_.id)
    
	// TODO define role (here or user)
}
  /*
   * class UserRoom(tag: Tag)
  extends Table[(Int, Int)](tag, "UserRooms") {

  def userId: Column[Int] = column("userId", O.NotNull)
  def roomId: Column[Int] = column("roomId", O.NotNull)

  def * : ProvenShape[(Int, Int)] = (userId, roomId)

  

  
}
   */
