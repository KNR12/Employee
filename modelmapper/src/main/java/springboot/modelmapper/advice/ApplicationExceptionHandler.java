package springboot.modelmapper.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleResourceNotFountExcepiton(RuntimeException exception,
                                                             WebRequest request){
        ErrorFile errorDetails= new ErrorFile(new Date(),exception.getMessage());
        return  new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalException(Exception exception,
                                                             WebRequest request){
        ErrorFile errorDetails= new ErrorFile(new Date(),exception.getMessage());
        return  new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument (MethodArgumentNotValidException ex){

        Map<String,String> errorMap = new HashMap<>() ;

        ex.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }



}
