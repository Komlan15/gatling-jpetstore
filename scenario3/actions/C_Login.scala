package animauxscala.scenario3.actions

import io.gatling.core.Predef._
import io.gatling.core.feeder.FeederBuilder
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._


object C_Login {
  private val headers_4 = Map(
    "Origin" -> "https://petstore.octoperf.com",
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "Upgrade-Insecure-Requests" -> "1"
  )
  val compteusers: FeederBuilder = csv("users.csv").random

  val login: ChainBuilder = {
    group("320_Login"){
      exec(feed(compteusers),
        http("/actions/Account.action")
          .post("/actions/Account.action")
          .headers(headers_4)
          .formParam("username", "#{Identifiant}")
          .formParam("password", "#{Password}")
          .formParam("signon", "Login")
          .formParam("_sourcePage", "#{sourcepage}")
          .formParam("__fp", "#{fp}")
          .check(regex("categoryId=(.*?)\"").findRandom.saveAs("categorieId"))
      )
    }
  }
}