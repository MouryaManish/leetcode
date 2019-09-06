package math.Exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import math.MainController;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler { 
		
		@ExceptionHandler
		 private ResponseEntity<Object> mainHandle(ResponseStatusException ex,WebRequest request){
		        return handleExceptionInternal(ex,ex.getMessage(),
		                new HttpHeaders(),ex.getStatus(),request);
		 }
}
