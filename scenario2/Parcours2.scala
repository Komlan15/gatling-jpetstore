package animauxscala.scenario2

import io.gatling.core.Predef._
import animauxscala.scenario2.actions.{A_Accueil2, B_Sigin, C_Login, D_ChoixAnimaux, E_Choix_Race, F_Choix_Item, G_Add_Cart, H_Checkout, I_Continue}
import io.gatling.core.structure.ChainBuilder

object Parcours2 {
  val parcours2: ChainBuilder = {
    exitBlockOnFail(
      exec(session => session)
        .exec(A_Accueil2.accueil)
        .pause(0)
        .exec(B_Sigin.sigin)
        .pause(0)
        .exec(C_Login.login)
        .pause(0)
        .exec(D_ChoixAnimaux.choix_animaux)
        .pause(0)
        .exec(E_Choix_Race.choix_race)
        .pause(0)
        .exec(F_Choix_Item.choix_item)
        .pause(0)
        .exec(G_Add_Cart.add_cart)
        .pause(0)
        .exec(H_Checkout.checkout)
        .pause(0)
        .exec(I_Continue.continue)
        .pause(0)
    )
  }
}
