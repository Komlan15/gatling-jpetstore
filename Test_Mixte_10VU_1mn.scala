package animauxscala
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure.ScenarioBuilder

class Test_Mixte_10VU_1mn extends Simulation {
  private val httpProtocol = http
    .baseUrl("https://petstore.octoperf.com")
    .disableCaching // Désacive le cache
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0")


  object TestMixte2 {
    val defaultLoadTest2: ScenarioBuilder =
      scenario("Default Load Test2")
        .during(30) {
          randomSwitch(
            60.0 -> exec(animauxscala.scenario1.Parcours1.parcours1),
            20.0 -> exec(animauxscala.scenario2.Parcours2.parcours2),
            20.0 -> exec(animauxscala.scenario3.Parcours3.parcours3)
          )
        }
  }

  setUp(TestMixte2.defaultLoadTest2.inject(atOnceUsers(2)).protocols(httpProtocol))
}