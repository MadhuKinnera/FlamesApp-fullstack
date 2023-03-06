package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FlameException.class)
	public ResponseEntity<MyErrorDetails> flameExceptionHandler(FlameException e,WebRequest req){
		
		MyErrorDetails me = new MyErrorDetails();
		
		me.setTimestamp(LocalDateTime.now());
		me.setMessage(e.getMessage());
		me.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails>  MethodExceptionHandler(MethodArgumentNotValidException e,WebRequest req){
		
		MyErrorDetails me = new MyErrorDetails();
		
		me.setTimestamp(LocalDateTime.now());
		me.setMessage("Validation Error");
		me.setDescription(e.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> NoHandlerFoundExceptionHandler(NoHandlerFoundException e,WebRequest req){
		
		MyErrorDetails me = new MyErrorDetails();
		
		me.setTimestamp(LocalDateTime.now());
		me.setMessage(e.getMessage());
		me.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception e,WebRequest req){
		
		MyErrorDetails me = new MyErrorDetails();
		
		me.setTimestamp(LocalDateTime.now());
		me.setMessage(e.getMessage());
		me.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
		
	}
	
	

}
