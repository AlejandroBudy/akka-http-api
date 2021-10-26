package es.alejandrobudy.api

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}

class ScalaHttpApiTest extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest {

  "ScalaHttpApi" should {
    "Respond successfully while request its status" in {
      Get("/status") ~> Routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe
          """
            | {
            | "status": "ok"
            | }
            |""".stripMargin
      }
    }
  }
}
