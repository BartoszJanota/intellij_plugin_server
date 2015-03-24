package com.plasma.bj.app.service.actors

import akka.actor.Actor
import akka.util.Timeout
import com.plasma.bj.app.models.{JSONResponseObject, JSONResponse}
import com.plasma.bj.app.utils.FortuneUtils
import spray.httpx.SprayJsonSupport
import spray.json.DefaultJsonProtocol
import spray.routing.{Route, Directives, HttpService}
import scala.concurrent.duration._


/**
 * Created by bj on 24.03.15.
 */
class BJPluginActorAPI extends Directives with Actor with HttpService with SprayJsonSupport with JSONResponseObject with DefaultJsonProtocol with FortuneUtils{


  implicit val timeout: Timeout = Timeout(5 seconds)

  def actorRefFactory = context

  def receive = runRoute(pluginRoutes)

  val pluginRoutes: Route =
      pathEndOrSingleSlash {
        get(
          complete("Welcome to BJ Plugin Server!")
        )
      }~
      pathPrefix("fortune") {
        pathEndOrSingleSlash {
          get(
            complete {
              JSONResponse(msg = getFortuneMsg)
            })
        }
      }
}
