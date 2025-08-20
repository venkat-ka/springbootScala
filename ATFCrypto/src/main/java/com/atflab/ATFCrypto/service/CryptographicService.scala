package com.atflab.ATFCrypto.service

import com.atflab.ATFCrypto.Dto.UserDto
import com.atflab.ATFCrypto.model.{EncryptRequestModel, EncryptResponseModel}
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CryptographicService @Autowired()(modelMapper: ModelMapper) {

  def mapEntityToDto(entity: EncryptRequestModel): EncryptResponseModel = {
    modelMapper.getConfiguration.setMatchingStrategy(MatchingStrategies.STRICT);
    val userDetails: UserDto = modelMapper.map(entity, classOf[UserDto]);
    val userResDetails: EncryptResponseModel = modelMapper.map(userDetails, classOf[EncryptResponseModel]);
    userResDetails;
  }

}
