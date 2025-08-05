package animauxscala.scenario1.actions

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef.http

object H_Checkout {
  private val headers_3 = Map(
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "Upgrade-Insecure-Requests" -> "1"
  )

  val Checkout: ChainBuilder = {
    group("170_Checkout"){
      exec(
        http("/actions/Order.action?newOrderForm=")
        .get("/actions/Order.action?newOrderForm=")
        .headers(headers_3),
      )
    }
  }
}