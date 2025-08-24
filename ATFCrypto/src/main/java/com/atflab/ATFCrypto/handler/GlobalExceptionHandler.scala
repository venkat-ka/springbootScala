package com.atflab.ATFCrypto.handler

import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.{ControllerAdvice, ExceptionHandler, ResponseStatus}
import org.springframework.web.context.request.WebRequest

import java.util.Date
//import scala.jdk.CollectionConverters._

@ControllerAdvice
class GlobalExceptionHandler {

  // Handle validation errors


  @ExceptionHandler(Array(classOf[MethodArgumentNotValidException]))
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  def badRequestFoundException(ex: MethodArgumentNotValidException, request: WebRequest ): ResponseEntity[Any]= {

    val errors = ex.getBindingResult.getFieldErrors
      .toArray()
      .map(_.asInstanceOf[FieldError])
      .map(fe => fe.getField -> fe.getDefaultMessage)
      .toMap

    val message = new ErrorMessage(HttpStatus.BAD_REQUEST.value, new Date(),ex.getMessage, request.getDescription(false), errors)

    ResponseEntity.badRequest().body(message)
  }


//  @ExceptionHandler(Array(classOf[CustomResourceNotFoundException]))
//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  def resourceNotFoundException(ex: CustomResourceNotFoundException, request: WebRequest ): ResponseEntity[ErrorMessage] = {
//        val errors = ex.getBindingResult.getFieldErrors.asScala
//          .map(fieldError => fieldError.getField -> fieldError.getDefaultMessage)
//          .toMap
//    val message = new ErrorMessage(HttpStatus.NOT_FOUND.value, new Date(), errors, request.getDescription(false))
//    //return new ErrorMessage(message, HttpStatus.NOT_FOUND)
//    return new ResponseEntity[ErrorMessage](message, HttpStatus.NOT_FOUND)
//  }

    @ExceptionHandler(Array(classOf[Exception]))
     @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
     def globalExceptionHandler(ex: Exception, request: WebRequest): ResponseEntity[ErrorMessage] = {

      val message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value, new Date(), ex.getMessage, request.getDescription(false), null)
    new ResponseEntity[ErrorMessage](message, HttpStatus.INTERNAL_SERVER_ERROR)
  }
}
