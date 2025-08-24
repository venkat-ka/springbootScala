package com.atflab.ATFCrypto.model

import jakarta.validation.constraints.{NotBlank, NotEmpty, NotNull}

class EncryptRequestPayload {
  //val plainText:String="def",val algorithm:String="def",var salt:String="def",val nonce:String="def",val four:String="def"
  @NotNull(message ="Plain Text cannot be empty")
  @NotBlank(message = "Plain Text cannot be blank")
  @NotEmpty
  private var plainText: String = _

  @NotNull(message ="algorithm Text cannot be empty")
  private var algorithm: String = _
  private var salt :String = _
  private var nonce:String = _
  private var four :String= _
  private var cypherText: String= _

  def this(plainText: String, algorithm: String,salt:String, nonce:String, four:String,cypherText:String) = {
    this()
    this.plainText = plainText
    this.algorithm = algorithm
    this.salt = salt
    this.nonce = algorithm
    this.four = four
    this.cypherText = cypherText
  }

  def getPlainText: String = plainText
  def getAlgorithm: String = algorithm
  def getSalt: String = salt
  def getNonce: String = nonce
  def getCypherText: String = cypherText


}
