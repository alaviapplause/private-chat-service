package com.applause.chat.dao

import scala.slick.driver.JdbcProfile
import scala.slick.driver.PostgresDriver.simple._

class DbClient(val driver: JdbcProfile) extends UserDao with RoomDao with TopicDao {//} with DbDriver {

    lazy val db = Database.forURL("jdbc:postgresql://localhost:5432/chat", "postgres", "postgres", driver = "org.postgresql.Driver")
    
	def create(implicit session: Session) = 
		(userTable.ddl ++ room.ddl ++ topic.ddl ++ MessageDao(this).ddl).create
		
	def dropCreate(implicit session: Session) {
	  	(userTable.ddl ++ room.ddl ++ topic.ddl ++ MessageDao(this).ddl).drop
	  	create
	}
		
}