package animauxscala.scenario2.actions

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object E_Choix_Race {
  private val headers_3 = Map(
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "Upgrade-Insecure-Requests" -> "1"
  )
  val choix_race: ChainBuilder = group("240_Choix_race"){
    exec(
      http("/actions/Catalog.action?viewProduct=&productId=#{ProductId}")
      .get("/actions/Catalog.action?viewProduct=&productId=#{ProductId}")
      .check(regex("itemId=(.*?)\"").findRandom.saveAs("ItemId"))
      .headers(headers_3),
    )
  }
}