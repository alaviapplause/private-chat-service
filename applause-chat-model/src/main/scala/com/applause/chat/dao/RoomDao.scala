package com.applause.chat.dao

import scala.slick.lifted.TableQuery
import com.applause.chat.model.Room

trait RoomDao {

	val room = TableQuery[Room]
}