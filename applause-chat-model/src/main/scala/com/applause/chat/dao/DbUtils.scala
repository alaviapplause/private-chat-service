package com.applause.chat.dao

import java.sql.DriverManager
import scala.collection.JavaConverters._

object DbUtils {
	
	def close {
		DriverManager.getDrivers.asScala.foreach{
		  d => DriverManager.deregisterDriver(d)
		}
	}
}