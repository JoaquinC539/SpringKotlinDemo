package com.kotlind.demo.config

import com.kotlind.demo.exceptions.AppException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    data class ErrorHandler(val code: Int, val description: String)

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<ErrorHandler> {
        return ResponseEntity.internalServerError().body(ErrorHandler(500, "Error at runtime: ${ex.message}"))
    }

    @ExceptionHandler(AppException::class)
    fun handleAppException(ex: AppException): ResponseEntity<ErrorHandler> {
        return ResponseEntity.ok().body(ErrorHandler(200, "Error at application: ${ex.message}"))
    }


}
