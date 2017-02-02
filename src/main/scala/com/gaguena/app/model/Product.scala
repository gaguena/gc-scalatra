package com.gaguena.app.model

import slick.driver.MySQLDriver.api._
import scala.concurrent.Future
import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

case class Product(code: String, name: String)

class Products(tag: Tag) extends Table[Product](tag, "product") {
  def code = column[String]("code", O.PrimaryKey, O.AutoInc)
  def name = column[String]("product_name")
  def * = (code, name) <> (Product.tupled, Product.unapply)
}

object Products {
  val db = Database.forConfig("mysql")
  private lazy val products = TableQuery[Products]

  def all = {
    val q = products
    Await.ready( db.run(q.result), 30.seconds)
  }
}

