package indrivo.dentistbooking.api.advice

import indrivo.dentistbooking.util.ErrorResponse
import org.apache.logging.log4j.LogManager
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlingControllerAdvice {

    private final val logger = LogManager.getLogger(this::class)

    /**
     * Handles invalid body exception
     * */
    @ExceptionHandler
    fun handleMessageNotReadableException(exception: HttpMessageNotReadableException): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body(ErrorResponse.UNREADABLE_BODY)
    }

    /**
     * Handles validation errors.
     * */
    @ExceptionHandler
    fun handleValidation(exception: MethodArgumentNotValidException): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body(exception.bindingResult.allErrors)
    }

    /**
     * Handles any unexpected exception
     * */
    @ExceptionHandler
    fun unknownExceptionHandler(exception: Exception): ResponseEntity<Any> {
        logger.error(exception)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
    }
}
