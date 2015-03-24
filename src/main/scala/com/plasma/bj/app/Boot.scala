package com.plasma.bj.app

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import com.plasma.bj.app.service.actors.BJPluginActorAPI
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._

/**
 * Created by bj on 24.03.15.
 */
object Boot extends App {

  implicit val system = ActorSystem("on-spray-can")

  val service = system.actorOf(Props[BJPluginActorAPI], "plugin-actor")

  implicit val timeout = Timeout(5.seconds)
  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)
}
