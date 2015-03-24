package com.plasma.bj.app.utils

import sys.process._

/**
 * Created by bj on 24.03.15.
 */
trait FortuneUtils {
  def getFortuneMsg: String = {
    "fortune" !!
  }
}
