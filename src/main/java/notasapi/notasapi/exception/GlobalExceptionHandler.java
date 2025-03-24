package notasapi.notasapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Manejo de excepciones personalizadas
    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<ErrorDetalles> handleRecursoNoEncontrado(RecursoNoEncontradoException ex, WebRequest request) {
        ErrorDetalles errorDetalles = new ErrorDetalles(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorDetalles, HttpStatus.NOT_FOUND);
    }

    // Manejo de validaciones con @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidations(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String campo = ((FieldError) error).getField();
            String mensaje = error.getDefaultMessage();
            errores.put(campo, mensaje);
        });
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    // Manejo de excepciones generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetalles> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDetalles errorDetalles = new ErrorDetalles(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorDetalles, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
