package cat.itacademy.barcelonactiva.camps.maya.s04.t02.n03.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.web.util.BindErrorUtils;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlingItemNotFound(NoSuchElementException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not available.");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handlingBadRequest(HttpMessageNotReadableException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input syntax error. \n" + e.getCause());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handlingRepeatedNameError(DataIntegrityViolationException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Error. \n" + e.getCause());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<String> handlingRepeatedNameError(DuplicateKeyException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Error. Item with this name already exists. \n" + e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handlingNullEntry(MethodArgumentNotValidException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input error. " + BindErrorUtils.resolveAndJoin(e.getFieldErrors()));
    }

    @ExceptionHandler({NoResourceFoundException.class})
    public ResponseEntity<String> handlingHttpNotFound(NoResourceFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error. Check URL. " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlingAllOtherExceptions(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error has occurred." + e.getMessage());
    }


}
