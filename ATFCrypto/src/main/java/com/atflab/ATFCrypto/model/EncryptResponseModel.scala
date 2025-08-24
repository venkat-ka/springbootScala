package com.atflab.ATFCrypto.model
class EncryptResponseModel {
  //val plainText:String="def",val algorithm:String="def",var salt:String="def",val nonce:String="def",val four:String="def"
  private var plainText: String = _
  private var algorithm: String = _
  private var salt :String = _
  private var nonce:String = _
  private var iv :String= _
  private var _cypherText: String= _
  def this(plainText: String, algorithm: String,salt:String, nonce:String, iv:String, _cypherText:String) = {
    this()
    this.plainText = plainText
    this.algorithm = algorithm
    this.salt = salt
    this.nonce = nonce
    this.iv = iv
    this._cypherText = _cypherText
  }
  def getPlainText: String = plainText
  def getAlgorithm: String = algorithm
  def getSalt: String = salt
  def getNonce: String = nonce
  def getIv: String = iv
  def getCypherText: String = _cypherText

//  def cypherText_=(value: String): Unit = {
//    _cypherText = value.toUpperCase
//  }

  def setcypherText(name: String): Unit = {
    _cypherText = name
  }

  def setPlainText(name: String): Unit = {
    plainText = name
  }

}
