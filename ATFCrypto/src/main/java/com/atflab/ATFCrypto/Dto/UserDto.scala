package com.atflab.ATFCrypto.Dto

import com.fasterxml.jackson.annotation.JsonProperty


case class UserDto() {
  @JsonProperty var plainText: String = _
  @JsonProperty var algorithm: String = _
  @JsonProperty var salt: String = _
  @JsonProperty var nonce: String = _
  @JsonProperty var iv: String = _

  def this(plainText: String, algorithm: String, salt:String,nonce:String,iv:String) = {
    this()
    this.plainText = plainText
    this.algorithm = algorithm
    this.salt = salt
    this.nonce = nonce
    this.iv = iv
  }
}
