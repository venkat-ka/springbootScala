package com.atflab.ATFCrypto.frontController

import com.atflab.ATFCrypto.model.{EncryptRequestModel, EncryptResponseModel}
import com.atflab.ATFCrypto.service.CryptographicService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, MediaType, ResponseEntity}
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RestController}


@RestController
class FrontController @Autowired()(cryptoService: CryptographicService){




  @RequestMapping(value=Array("/encrypt"),
    consumes=Array(MediaType.APPLICATION_JSON_VALUE),
    produces=Array(MediaType.APPLICATION_JSON_VALUE))
  def encrypt(@RequestBody request: EncryptRequestModel): ResponseEntity[EncryptResponseModel] = {
    var encryptData: EncryptResponseModel = cryptoService.mapEntityToDto(request);
     return ResponseEntity.status(HttpStatus.CREATED).body(encryptData);
  }

//  @GetMapping(value=Array("/hello"), produces=Array(MediaType.APPLICATION_JSON_VALUE))
//  def demo: ResponseEntity[EncryptResponseModel]  = {
//    return ResponseEntity.status(HttpStatus.CREATED).body(new EncryptResponseModel("dd","fg","s","c","v"));
//  }



}
