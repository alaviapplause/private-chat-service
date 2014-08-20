package com.applause.chat.dao

import scala.slick.driver.PostgresDriver.simple._
import com.applause.chat.model.User
import com.applause.chat.model.UserEntity
import com.applause.chat.model.UserEntity

trait UserDao { //this: DbDriver =>

	// The query interface for the Suppliers table
	val userTable = TableQuery[User]
	
	private val userAutoInc =
    	userTable.map(u => (u.name, u.presenceStatus)) returning userTable.map(_.id)
    
	def insert(user: UserEntity)(implicit session: Session): UserEntity = {
	  println("Insert new user:" + user)
	  val id = userAutoInc.insert(user.name, user.presenceStatus.get)
	  user.copy(name = user.name, presenceStatus = user.presenceStatus, id = Option(id))
	}
	
}
