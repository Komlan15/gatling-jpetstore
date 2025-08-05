package animauxscala.scenario1
import io.gatling.core.Predef._
import animauxscala.scenario1.actions.{A_Accueil, B_Sigin, C_Login, D_ChoixAnimaux, E_Choix_Race, F_Choix_Item, G_Add_Cart, H_Checkout, I_Continue, J_Confirm}
import io.gatling.core.structure.ChainBuilder

object Parcours1 {
  val parcours1: ChainBuilder = {
    exitBlockOnFail( // Si une erreur survient aller à l'itération suivante
      exec(session => session)
        .exec(A_Accueil.Accueil)
        .pause(0)
        .exec(B_Sigin.Sigin)
        .pause(0)
        .exec(C_Login.Login)
        .pause(0)
        .exec(D_ChoixAnimaux.Choix_animaux)
        .pause(0)
        .exec(E_Choix_Race.Choix_race)
        .pause(0)
        .exec(F_Choix_Item.Choix_item)
        .pause(0)
        .exec(G_Add_Cart.Add_cart)
        .pause(0)
        .exec(H_Checkout.Checkout)
        .pause(0)
        .exec(I_Continue.Continue)
        .pause(0)
        .exec(J_Confirm.Confirm)

    )
  }
}
