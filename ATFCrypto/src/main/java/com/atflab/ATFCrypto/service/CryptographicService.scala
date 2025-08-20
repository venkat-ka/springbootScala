package com.atflab.ATFCrypto.service

import com.atflab.ATFCrypto.model.{EncryptRequestModel, EncryptResponseModel, RequestPayload}
import org.modelmapper.ModelMapper
import org.modelmapper.config.Configuration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CryptographicService @Autowired()(modelMapper: ModelMapper) {

  def mapEntityToDto(entity: EncryptRequestModel): EncryptResponseModel = {
    //modelMapper.getConfiguration.setMatchingStrategy(MatchingStrategies.STRICT);
    //val re : EncryptResponseModel= new EncryptResponseModel("c","v","v", "e","e");
   // val userDetails: EncryptResponseModel = modelMapper.map(re, classOf[EncryptResponseModel]);
   // val userResDetails: EncryptResponseModel = modelMapper.map(userDetails, classOf[EncryptResponseModel]);
      val jd : RequestPayload= new RequestPayload(entity.plainText,entity.algorithm,entity.salt, entity.four,"e");
    modelMapper.getConfiguration.setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    val ffg: EncryptResponseModel = modelMapper.map(entity, classOf[EncryptResponseModel])
    //ffg.greet()
    ffg;
  }

}
