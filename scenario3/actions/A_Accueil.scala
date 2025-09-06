package animauxscala.scenario3.actions

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object A_Accueil {

  private val headers_0 = Map(
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "none",
    "Sec-Fetch-User" -> "?1",
    "Upgrade-Insecure-Requests" -> "1"
  )

  val accueil: ChainBuilder =  group("300_Acceuill"){
    exec(
      http("/actions/Catalog.action")
      .get("/actions/Catalog.action")
      .check(
        headerRegex("set-cookie", "JSESSIONID=(.*?);")
          .ofType[String]
          .saveAs("jsessionid")
      )
      .headers(headers_0),
    )
  }
}
