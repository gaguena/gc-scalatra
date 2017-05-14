package com.gaguena.app.model

import java.time.LocalDateTime

case class Posting(id: Option[Long], title: String, text: String, version: Option[Int], dhRegister: LocalDateTime)
