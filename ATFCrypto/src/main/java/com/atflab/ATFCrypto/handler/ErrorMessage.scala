package com.atflab.ATFCrypto.handler

import java.util.Date

class ErrorMessage(private var statusCode: Int, private var timestamp: Date, private var message: String, private var description: String, private var inputField: Map[String, String] ) {
  def getStatusCode: Int = statusCode

  def getTimestamp: Date = timestamp

  def getMessage: String = message

  def getDescription: String = description

  def getInputfield: Map[String, String] = inputField
}
