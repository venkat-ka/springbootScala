package com.atflab.ATFCrypto.model
class EncryptResponseModel {
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
//@AllArgsConstructor
//class EncryptResponseModel (val plainText:String="def",val algorithm:String="def",var salt:String="def",val nonce:String="def",val four:String="def") {
//  def this() = this("pp", "","","","")
//
//  def greet():String = {
//    //this(plainText,algorithm, salt, nonce,four)
//    plainText
//  }
//}
//{
//  //(plainText: String, algorithm: String, salt:String, nonce:String, four:String)
////  def this() = {
////    this("","","","","")
////  }
////  def this(plainText: String, algorithm: String, salt:String,nonce:String,four:String ) = {
////    this(plainText, algorithm, salt, nonce, four)  // calls primary constructor
////    this.plainText = plainText
////  }
//  //def this(plainText: String, algorithm: String, salt:String, nonce:String, four:String) = this(plainText, algorithm, salt, nonce, four)
//  //def this(plainText:String,algorithm:String,salt:String,nonce:String,four:String) = this(plainText,algorithm,salt,nonce,four)
////  var plainText: String = _
////  var algorithm: String = _
////  var salt:String = _
////  var nonce:String = _
////  var four:String = _
//}
