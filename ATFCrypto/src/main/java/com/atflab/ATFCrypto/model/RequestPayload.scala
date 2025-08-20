package com.atflab.ATFCrypto.model

class RequestPayload {
  //val plainText:String="def",val algorithm:String="def",var salt:String="def",val nonce:String="def",val four:String="def"
  private var plainText: String = _
  private var algorithm: String = _
  private var salt :String = _
  private var nonce:String = _
  private var four :String= _
  def this(plainText: String, algorithm: String,salt:String, nonce:String, four:String) = {
    this()
    this.plainText = plainText
    this.algorithm = algorithm
    this.salt = salt
    this.nonce = algorithm
    this.four = four
  }
}
