package animauxscala.scenario1.actions

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef.http

object I_Continue {
  private val headers_4 = Map(
    "Origin" -> "https://petstore.octoperf.com",
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "Upgrade-Insecure-Requests" -> "1"
  )
  val compteusers = csv("users.csv").random

  val Continue: ChainBuilder = {
    group("180_Continue"){
      exec(
        feed(compteusers),
        http("/actions/Order.action")
          .post("/actions/Order.action")
          .headers(headers_4)
          .formParam("order.cardType", "Visa")
          .formParam("order.creditCard", "999 9999 9999 9999")
          .formParam("order.expiryDate", "12/03")
          .formParam("order.billToFirstName", "#{FirstName}")
          .formParam("order.billToLastName", "#{LastName}")
          .formParam("order.billAddress1", "#{Address1}")
          .formParam("order.billAddress2", "#{Address2}")
          .formParam("order.billCity", "#{City}")
          .formParam("order.billState", "#{State}")
          .formParam("order.billZip", "#{Zip}")
          .formParam("order.billCountry", "France")
          .formParam("newOrder", "Continue")
          .formParam("_sourcePage", "#{sourcepage}")
          .formParam("__fp", "#{fp}"),
      )
    }
  }
}

