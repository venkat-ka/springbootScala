package com.atflab.ATFCrypto.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor

@Configuration
class AppConfig {
  @Bean
  def modelMapper(): ModelMapper = new ModelMapper()

  @Bean
  def methodValidationPostProcessor(): MethodValidationPostProcessor = new MethodValidationPostProcessor()
}