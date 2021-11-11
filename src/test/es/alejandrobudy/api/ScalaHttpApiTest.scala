package es.alejandrobudy.api

import akka.http.scaladsl.model.{ContentTypes, StatusCodes}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}
import spray.json._

class ScalaHttpApiTest extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest {

  case class UserStub(id: String, name: String)

  object UserStub {
    def apply(id: String, name: String): User = User(id, name)
  }

  object UserMarshaller {
    def marshall(users: Seq[User]): JsArray = JsArray(
      users.map(user =>
        JsObject(
          "id" -> JsString(user.id.id.toString),
          "name" -> JsString(user.name.name)
        )
      ).toVector
    )
  }

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

    "Respond successfully return pong" in {
      Get("/ping") ~> Routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe
          """
            | {
            | "data": "pong"
            | }
            |""".stripMargin
      }
    }

    "Respond successfully with user list" in {
      Get("/users") ~> Routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        val expectedUsers = Seq(
          UserStub("73aec926-7840-4a44-87e0-2d540e37e636", "Alejandro"),
          UserStub("73aec926-7840-4a44-87e0-2d540e37e636", "Budy"))
        entityAs[String].parseJson shouldBe UserMarshaller.marshall(expectedUsers)
      }
    }
  }
}
