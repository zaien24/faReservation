package com.work.fareservation.common.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun handleBusineessException(e: BusinessException): ResponseEntity<ErrorResponse> {
        val response = ErrorResponse(
            code = "400",
            message = e.message ?: "비즈니스 로직 에러가 발생했습니다."
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }
}

data class ErrorResponse(
    val code: String,
    val message: String,
)