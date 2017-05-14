package com.gaguena.app.rest

import com.gaguena.app.model.Posting
import java.time.LocalDateTime

class PostingRest extends JsonSupportRest {

  get("/") {
    Posting(Some(1), "Teste", "teste teste", Some(1), LocalDateTime.now)
  }
}