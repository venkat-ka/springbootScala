package com.atflab.ATFCrypto.frontController

import com.atflab.ATFCrypto.model.RequestModel
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}


@RestController
class FrontController {




  @RequestMapping(Array("/encrypt"), produces=Array(MediaType.APPLICATION_JSON),
    consumes=Array(MediaType.APPLICATION_JSON))
  def encrypt(): RequestModel = {
    new RequestModel();
  }

  @GetMapping(Array("/hello"))
  def demo: String = {
    "Welcome to Spring boot scala."
  }



}
