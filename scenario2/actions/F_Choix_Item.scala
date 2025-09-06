package animauxscala.scenario2.actions

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef.http

object F_Choix_Item {
  private val headers_3 = Map(
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "Upgrade-Insecure-Requests" -> "1"
  )

  val choix_item: ChainBuilder = group("250_Choix_item"){
    exec(http("/actions/Catalog.action?viewItem=&itemId=#{ItemId}")
      .get("/actions/Catalog.action?viewItem=&itemId=#{ItemId}")
      .headers(headers_3),
    )
  }
}