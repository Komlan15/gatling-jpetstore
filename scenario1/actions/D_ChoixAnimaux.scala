package animauxscala.scenario1.actions

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._


object D_ChoixAnimaux {

  val categoryid = csv("resources-jpetstore-gatling/categorie.csv").random
  private val headers_3 = Map(
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "Upgrade-Insecure-Requests" -> "1"
  )
  val Choix_animaux: ChainBuilder = group("130_Choix_animaux"){
    exec(
      http("/actions/Catalog.action?viewCategory=&categoryId=#{categorieId}")
      .get("/actions/Catalog.action?viewCategory=&categoryId=#{categorieId}")
      .check(regex("productId=(.*?)\"").findRandom.saveAs("ProductId"))
      .headers(headers_3)
    )
  
  }
}