package com.applause.chat

import scala.slick.driver.PostgresDriver
import scala.slick.jdbc.JdbcBackend.Database
import com.applause.chat.dao.DbClient
import com.applause.chat.dao.DbUtils
import com.applause.chat.model.MessageEntity
import com.applause.chat.model.UserEntity
import com.applause.chat.dao.MessageDao


object DbExampleApp extends App {

  def run(client: DbClient, db: Database) {
    println("Running test against " + client.driver)
    
    db withSession { implicit session =>
		client.dropCreate
		val user1 = client.insert(UserEntity("user1"))
		val user2 = client.insert(UserEntity("user2", Option("Online")))
		println("Inserted users")
		
		val message = MessageDao(client).createMessage("hello lalala", user1.id.get, 1)
		println("Sent message " + message)
		
		println("Finished session")
    }
  }
  
  try {
    run(new DbClient(PostgresDriver),
        Database.forURL("jdbc:postgresql://localhost:5432/chat", "postgres", "postgres", driver = "org.postgresql.Driver"))
  } finally DbUtils.close
}