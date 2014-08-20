package com.applause.chat.model

import scala.slick.driver.PostgresDriver.simple._

case class UserEntity(name: String, presenceStatus: Option[String] = Some("Offline"), id: Option[Int] = None) {
	//val createdAt = System.currentTimeMillis()
}

/*
 * Both the Relational Model and the Scala programming language have constructs named tuple, and the two are not consistent with each other. 
 * Specifically, the elements of a tuple in the Relational Model are unordered as a set, and distinguished by name. 
 * Inconsistently, the elements of a a Scala Tuple are ordered and distinguished by position. 
 * For this reason, we find that if our goal is to be as faithful to the Relational Model as possible, the Scala Tuple is not the best way to represent at a relational tuple. 
 * We prefer  Scala construct that better meets our goal: the case class, rather than using a TableQuery parametrized with a class extending Slick's Table class
 */
class User(tag: Tag) extends Table[UserEntity](tag, "User") {
  
	def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
	def name = column[String]("userName", O.NotNull)
	// TODO define presenceStatus as enum
	def presenceStatus = column[String]("presenceStatus", O.NotNull)

	// the tupled factory method takes a Tuple and returns a case class, and the unapply extractor method that goes in the opposite direction, returning an Option[Tuple]
	def * = (name, presenceStatus.?, id.?) <> (UserEntity.tupled, UserEntity.unapply)
}