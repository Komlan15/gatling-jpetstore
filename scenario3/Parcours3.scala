package animauxscala.scenario3
import animauxscala.scenario3.actions.{A_Accueil, B_Sigin, C_Login, D_ChoixAnimaux}
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder

object Parcours3 {
  val parcours3: ChainBuilder = {
    exitBlockOnFail(
      exec (session => session)
        .exec(A_Accueil.accueil)
        .pause(0)
        .exec(B_Sigin.sigin)
        .pause(0)
        .exec(C_Login.login)
        .pause(0)
        .exec(D_ChoixAnimaux.choix_animaux)
        .pause(0)
    )

  }
}
