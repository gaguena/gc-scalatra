package com.gaguena.app.tables

import java.time.LocalDateTime

import scala.concurrent._
import scala.concurrent.duration._

import com.gaguena.app.model.Posting

import slick.driver.MySQLDriver.api._

import com.gaguena.app.tables.DataBaseImplicits._

class PostingTable(tag: Tag) extends Table[Posting](tag, "posting") {
  def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def title = column[String]("title")
  def text = column[String]("text")
  def version = column[Option[Int]]("register_version")
  def dhRegister = column[LocalDateTime]("dh_register")
  def * = (id, title, text, version, dhRegister) <> (Posting.tupled, Posting.unapply)
}

trait Postings {
  val db = Database.forConfig("mysql")
  private lazy val postings = TableQuery[PostingTable]

  def all = {
    val q = postings
    Await.ready( db.run(q.result), 30.seconds)
  }
}