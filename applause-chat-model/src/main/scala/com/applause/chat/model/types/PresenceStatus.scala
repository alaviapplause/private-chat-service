package com.applause.chat.model.types

import scala.slick.driver.PostgresDriver.simple._

object PresenceStatus extends Enumeration {

  val Online, Offline = Value
  
}