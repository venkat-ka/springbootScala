package com.atflab.ATFCrypto.frontController

import com.atflab.ATFCrypto.model.{DecryptRequestPayload, EncryptRequestPayload, EncryptResponseModel}
import com.atflab.ATFCrypto.service.CryptographicService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, MediaType, ResponseEntity}
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RestController}

@Validated
@RestController
class FrontController @Autowired()(cryptoService: CryptographicService){




  @RequestMapping(value=Array("/encrypt"),
    consumes=Array(MediaType.APPLICATION_JSON_VALUE),
    produces=Array(MediaType.APPLICATION_JSON_VALUE))
  def encrypt(@Valid @RequestBody request: EncryptRequestPayload): ResponseEntity[Any] = {
    var encryptData: EncryptResponseModel = cryptoService.encryptCode(request);

    ResponseEntity.status(HttpStatus.CREATED).body(encryptData);


  }

  @RequestMapping(value=Array("/decrypt"),
    consumes=Array(MediaType.APPLICATION_JSON_VALUE),
    produces=Array(MediaType.APPLICATION_JSON_VALUE))
  def decrypt(@Valid @RequestBody request: DecryptRequestPayload): ResponseEntity[Any] = {
    var encryptData: EncryptResponseModel = cryptoService.decryptCode(request);

    ResponseEntity.status(HttpStatus.CREATED).body(encryptData);


  }

}
