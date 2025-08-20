package com.atflab.ATFCrypto.Dto

import lombok.NoArgsConstructor

@NoArgsConstructor
case class UserDto (plainText: String, algorithm: String, salt:String,nonce:String,four:String)