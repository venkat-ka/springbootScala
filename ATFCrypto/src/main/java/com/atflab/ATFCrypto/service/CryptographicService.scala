package com.atflab.ATFCrypto.service

import com.atflab.ATFCrypto.model.{DecryptRequestPayload, EncryptRequestPayload, EncryptResponseModel}
import com.atflab.ATFCrypto.util.RSAUtil
import org.modelmapper.ModelMapper
import org.modelmapper.config.Configuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Service
@Validated
class CryptographicService @Autowired()(modelMapper: ModelMapper) {
  val keyPair = RSAUtil.generateKeyPair()
  ///Env config  refer val publicKeyStr = Base64.getEncoder.encodeToString(keyPair.getPublic.getEncoded)
  // Env config refer val privateKeyStr = Base64.getEncoder.encodeToString(keyPair.getPrivate.getEncoded)

  // Encrypting the  plaintext
  def encryptCode(entity: EncryptRequestPayload): EncryptResponseModel = {
    val encrypted = RSAUtil.encrypt(entity.getPlainText, keyPair.getPublic)
    Map("encrypted" -> encrypted);
    modelMapper.getConfiguration.setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    var resPonseEntity: EncryptResponseModel = modelMapper.map(entity, classOf[EncryptResponseModel])
    resPonseEntity.setcypherText(encrypted)
    resPonseEntity
  }

  // Decrypting the  plaintext
  def decryptCode(entity: DecryptRequestPayload): EncryptResponseModel = {

    var resPonseEntity: EncryptResponseModel = modelMapper.map(entity, classOf[EncryptResponseModel])
    val decrypted = RSAUtil.decrypt(entity.getCypherText, keyPair.getPrivate)
    Map("decrypt" -> decrypted);
    modelMapper.getConfiguration.setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    resPonseEntity.setPlainText(decrypted)

    resPonseEntity
  }

}
