package com.atflab.ATFCrypto


import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class AtfCryptoApplication

object AtfCryptoApplication extends App {
  SpringApplication.run(classOf[AtfCryptoApplication], args:_*)
}