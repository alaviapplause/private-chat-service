package com.applause.chat.model

import scala.slick.driver.PostgresDriver.simple._

case class RoomEntity(name: String, status: String, testCycleId: Int, id: Option[Int] = None) {
    val createdAt = System.currentTimeMillis
}

class Room(tag: Tag) extends Table[RoomEntity](tag, "Room") {

	def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
	def name = column[String]("roomName", O.NotNull)
	def status = column[String]("status", O.NotNull)
	def testCycleId = column[Int]("testCycleId", O.NotNull)

	// the * projection (e.g. select * ...) auto-transforms the tupled
	// column values to / from a Room
	def * = (name, status, testCycleId, id.?) <> (RoomEntity.tupled, RoomEntity.unapply)
}
