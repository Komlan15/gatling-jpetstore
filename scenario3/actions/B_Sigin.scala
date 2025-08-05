package animauxscala.scenario3.actions

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object B_Sigin {

  private val headers_3 = Map(
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "Upgrade-Insecure-Requests" -> "1"
  )
  val sigin: ChainBuilder = {
    group("310_Sigin"){
      exec(
        http("/actions/Account.action;jsessionid=jsessionid?signonForm=")
        .get("/actions/Account.action;jsessionid=#{jsessionid}?signonForm=")
        .check(regex("sourcePage\" value=\"(.*?)\"").saveAs("sourcepage"))
        .check(regex("fp\" value=\"(.*?)\"").saveAs("fp"))
        .headers(headers_3),
      )
    }
  }
}
