package com.applause.chat.dao

import com.applause.chat.model.Topic
import scala.slick.lifted.TableQuery

trait TopicDao {

	val topic = TableQuery[Topic]
}