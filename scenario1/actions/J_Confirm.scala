package animauxscala.scenario1.actions

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef.http

object J_Confirm {
  private val headers_3 = Map(
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "Upgrade-Insecure-Requests" -> "1"
  )

  val Confirm: ChainBuilder = group("190_Confirm"){
    exec(
      http("/actions/Order.action?newOrder=&confirmed=true")
        .get("/actions/Order.action?newOrder=&confirmed=true")
        .headers(headers_3)
    )
  }
}
