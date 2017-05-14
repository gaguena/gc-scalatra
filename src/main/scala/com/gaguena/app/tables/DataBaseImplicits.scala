package com.gaguena.app.tables

import java.sql.Timestamp
import java.time.LocalDateTime
import slick.driver.MySQLDriver.api._
import java.time.ZoneOffset

object DataBaseImplicits {
  implicit val localDateTimeColumnType = MappedColumnType.base[LocalDateTime, Timestamp](
    d => Timestamp.from(d.toInstant(ZoneOffset.ofHours(0))),
    d => d.toLocalDateTime)
}