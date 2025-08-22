package com.atflab.ATFCrypto.util

import java.security.{KeyFactory, KeyPair, KeyPairGenerator, PrivateKey, PublicKey}
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher
import java.util.Base64

object RSAUtil {
  // Environment specific update requeired
  val RSA = "RSA"
  val keySize = 2048

  def generateKeyPair(): KeyPair = {
    val keyGen = KeyPairGenerator.getInstance(RSA)
    keyGen.initialize(keySize)
    keyGen.generateKeyPair()
  }

  def encrypt(plainText: String, publicKey: PublicKey): String = {
    val cipher = Cipher.getInstance(RSA)
    cipher.init(Cipher.ENCRYPT_MODE, publicKey)
    val encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"))
    Base64.getEncoder.encodeToString(encryptedBytes)
  }

  def decrypt(cipherText: String, privateKey: PrivateKey): String = {
    val cipher = Cipher.getInstance(RSA)
    cipher.init(Cipher.DECRYPT_MODE, privateKey)
    val decodedBytes = Base64.getDecoder.decode(cipherText)
    new String(cipher.doFinal(decodedBytes), "UTF-8")
  }

  def publicKeyFromBase64(base64PublicKey: String): PublicKey = {
    val keyBytes = Base64.getDecoder.decode(base64PublicKey)
    val spec = new X509EncodedKeySpec(keyBytes)
    val kf = KeyFactory.getInstance(RSA)
    kf.generatePublic(spec)
  }

  def privateKeyFromBase64(base64PrivateKey: String): PrivateKey = {
    val keyBytes = Base64.getDecoder.decode(base64PrivateKey)
    val spec = new PKCS8EncodedKeySpec(keyBytes)
    val kf = KeyFactory.getInstance(RSA)
    kf.generatePrivate(spec)
  }
}
