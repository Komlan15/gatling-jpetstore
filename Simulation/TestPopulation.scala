package animauxscala.Simulation

import io.gatling.core.Predef._
import io.gatling.core.structure.PopulationBuilder
import scala.concurrent.duration._

object TestPopulation {
  val instantUsers: PopulationBuilder=
    TestMixte.defaultLoadTest
      .inject(
        nothingFor(5.seconds),
        atOnceUsers(10)
      )

  val complexInjection: PopulationBuilder =
    TestMixte.defaultLoadTest
      .inject(
        constantUsersPerSec(10).during(20.seconds),
        rampUsersPerSec(10) to 20 during 20.seconds
      )

  val closedModel: PopulationBuilder =
    TestMixte.defaultLoadTest
      .inject(
        constantConcurrentUsers(10) during 20.seconds,
        rampConcurrentUsers(10) to 20 during 20.seconds
      )
}
