package com.atflab.ATFCrypto.service

import com.atflab.ATFCrypto.model.{EncryptRequestModel, EncryptResponseModel}
import com.atflab.ATFCrypto.util.RSAUtil
import org.modelmapper.ModelMapper
import org.modelmapper.config.Configuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CryptographicService @Autowired()(modelMapper: ModelMapper) {
  val keyPair = RSAUtil.generateKeyPair()
 /// val publicKeyStr = Base64.getEncoder.encodeToString(keyPair.getPublic.getEncoded)
//  val privateKeyStr = Base64.getEncoder.encodeToString(keyPair.getPrivate.getEncoded)

  def mapEntityToDto(entity: EncryptRequestModel): EncryptResponseModel = {
    val encrypted = RSAUtil.encrypt(entity.plainText, keyPair.getPublic)
    Map("encrypted" -> encrypted);

    modelMapper.getConfiguration.setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    var resPonseEntity: EncryptResponseModel = modelMapper.map(entity, classOf[EncryptResponseModel])

    resPonseEntity.cypherText   = encrypted
    resPonseEntity
  }

}
