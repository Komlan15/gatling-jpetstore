package animauxscala
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.structure.ScenarioBuilder

class Test_Unitaire_SC02 extends Simulation{

  private val httpProtocol = http
    .baseUrl("https://petstore.octoperf.com")
    .disableCaching // Désactivation du cache
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:125.0) Gecko/20100101 Firefox/125.0")
  // Définition des scénarios

  val scn2: ScenarioBuilder = scenario("Scenario 1")

    .repeat(10){
        exec(flushHttpCache)
        .exec(flushSessionCookies)
        .exec(flushCookieJar)
        .exec(animauxscala.scenario2.Parcours2.parcours2)
    }

  // Définir la simulation

  setUp(
    scn2.inject(atOnceUsers(1)).protocols(httpProtocol),
  )
}

