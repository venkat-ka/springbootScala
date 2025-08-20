package com.atflab.ATFCrypto.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class AppConfig {
  @Bean
  def modelMapper(): ModelMapper = new ModelMapper()
}