package com.gaguena.app

import org.json4s.{ DefaultFormats, Formats }
import org.scalatra.json.JacksonJsonSupport
import scala.concurrent.ExecutionContext.Implicits.global

import com.gaguena.app.model.{ Product, Products }

class MyScalatraServlet extends MyapprestStack with JacksonJsonSupport {
  
protected implicit val jsonFormats: Formats = DefaultFormats

// Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
  }

  get("/") {
    val product = Product("0003", "Banana")
    for{
      v <- Products.all
    } yield v
  }

}