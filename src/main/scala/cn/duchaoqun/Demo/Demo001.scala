package cn.duchaoqun.Demo

import com.typesafe.scalalogging._

// https://github.com/lightbend/scala-logging

object Demo001 extends App with LazyLogging {
  logger.info("INFO")
  logger.warn("WARN")
  logger.error("ERROR")
}
