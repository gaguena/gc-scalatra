package com.gaguena.app.rest

import org.scalatra.scalate.ScalateSupport
import org.scalatra.ScalatraServlet
import org.scalatra.json.JacksonJsonSupport
import org.json4s.{ DefaultFormats, Formats }

trait JsonSupportRest extends ScalatraServlet with ScalateSupport with JacksonJsonSupport {

  override val contentType = formats("json")

  protected implicit val jsonFormats: Formats = DefaultFormats

}
