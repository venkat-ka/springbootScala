package com.atflab.ATFCrypto.frontController

import org.springframework.web.bind.annotation.{GetMapping, RestController}


@RestController
class FrontController {
//  @GetMapping(Array("/hello"))
//  def sayHello(): Map[String, String] = {
//    Map("message" -> "Hello from Scala and Spring Boot!")
//  }

  @GetMapping(Array("/hello"))
  def demo: String = {
    "Welcome to Janus executor engine."
  }
}
