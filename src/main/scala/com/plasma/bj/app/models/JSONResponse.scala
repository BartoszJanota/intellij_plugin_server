package com.plasma.bj.app.models

import spray.json.DefaultJsonProtocol

/**
 * Created by bj on 24.03.15.
 */
case class JSONResponse(msg: String){}

trait JSONResponseObject extends DefaultJsonProtocol{
  implicit val jSONResponseObjectFormat = jsonFormat1(JSONResponse.apply)
}

object JSONResponseObject extends JSONResponseObject
