package animauxscala
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import io.gatling.core.structure.ScenarioBuilder

class Test_Mixte_10VU_5mn extends Simulation{

  private val httpProtocol = http
    .baseUrl("https://petstore.octoperf.com")
    .disableCaching // Désactivation du cache
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0")

  // Définition des scénarios

  val scn1: ScenarioBuilder = scenario("Scenario 1")
    .exec(animauxscala.scenario1.Parcours1.parcours1)

  val scn2: ScenarioBuilder = scenario("Scenario 2")
    .exec(animauxscala.scenario2.Parcours2.parcours2)

  val scn3: ScenarioBuilder = scenario("Scenario 3")
    .exec(animauxscala.scenario3.Parcours3.parcours3)

  // Définir la simulation

  setUp(
    scn1.inject(constantUsersPerSec(6).during(5.minutes)).protocols(httpProtocol), // 60% de 10VU

    scn2.inject(constantUsersPerSec(3).during(5.minutes)).protocols(httpProtocol), // 30% de 10VU

    scn3.inject(constantUsersPerSec(1).during(5.minutes)).protocols(httpProtocol) // 10% de 10VU
  )
}
