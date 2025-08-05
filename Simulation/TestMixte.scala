package animauxscala.Simulation

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

  object TestMixte {
    val defaultLoadTest: ScenarioBuilder =
      scenario("Default Load Test")
        .during(30) {
          randomSwitch(
            60.0 -> exec(animauxscala.scenario1.Parcours1.parcours1),
            20.0 -> exec(animauxscala.scenario2.Parcours2.parcours2),
            20.0 -> exec(animauxscala.scenario3.Parcours3.parcours3)
          )
        }
  }


