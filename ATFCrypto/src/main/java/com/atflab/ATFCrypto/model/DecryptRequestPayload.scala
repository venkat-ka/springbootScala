package com.atflab.ATFCrypto.model

import jakarta.validation.constraints.NotNull

class DecryptRequestPayload {
  //val plainText:String="def",val algorithm:String="def",var salt:String="def",val nonce:String="def",val four:String="def"
  @NotNull(message ="Cypher Text cannot be empty")
  private var cypherText: String= _

  private var algorithm: String = _
  private var salt :String = _
  private var nonce:String = _
  private var iv :String= _


  def this( algorithm: String,salt:String, nonce:String, iv:String,cypherText:String) = {
    this()

    this.algorithm = algorithm
    this.salt = salt
    this.nonce = nonce
    this.iv = iv
    this.cypherText = cypherText
  }

  def getAlgorithm: String = algorithm
  def getSalt: String = salt
  def getNonce: String = nonce
  def getCypherText: String = cypherText
  def getIv : String = iv;

}
