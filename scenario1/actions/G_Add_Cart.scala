package animauxscala.scenario1.actions

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef.http

object G_Add_Cart {
  private val headers_3 = Map(
    "Sec-Fetch-Dest" -> "document",
    "Sec-Fetch-Mode" -> "navigate",
    "Sec-Fetch-Site" -> "same-origin",
    "Sec-Fetch-User" -> "?1",
    "Upgrade-Insecure-Requests" -> "1"
  )

  val Add_cart: ChainBuilder = group("160_Add_cart"){
    exec(
      http("/actions/Cart.action?addItemToCart=&workingItemId=#{ItemId}")
      .get("/actions/Cart.action?addItemToCart=&workingItemId=#{ItemId}")
      .headers(headers_3)
    )
  }
}