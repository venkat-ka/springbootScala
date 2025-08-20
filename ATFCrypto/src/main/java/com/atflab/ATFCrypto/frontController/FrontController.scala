package com.atflab.ATFCrypto.frontController

import com.atflab.ATFCrypto.model.{EncryptRequestModel, EncryptResponseModel}
import com.atflab.ATFCrypto.service.CryptographicService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, MediaType, ResponseEntity}
import org.springframework.web.bind.annotation.{GetMapping, RequestBody, RequestMapping, RestController}


@RestController
class FrontController @Autowired()(cryptoService: CryptographicService){




  @RequestMapping(value=Array("/encrypt"), produces=Array(MediaType.APPLICATION_JSON_VALUE),
    consumes=Array(MediaType.APPLICATION_JSON_VALUE))
  def encrypt(@RequestBody request: EncryptRequestModel): ResponseEntity[EncryptResponseModel] = {
    var encryptData: EncryptResponseModel = cryptoService.mapEntityToDto(request);
     ResponseEntity.status(HttpStatus.CREATED).body(encryptData);
  }

  @GetMapping(Array("/hello"))
  def demo: String = {
    "Welcome to Spring boot scala."
  }



}
