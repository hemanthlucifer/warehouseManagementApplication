package com.application.warehouseManagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(GoodownNotFoundException.class)
	public ResponseEntity<String> goodownNotFound(GoodownNotFoundException exception) {
		MessageBuilder response = new MessageBuilder();
		String message = response.responseBuilder(MessageCodes.goodownNotFound, exception.getMessage());
		return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<String> categoryNotFound(CategoryNotFoundException exception){
		MessageBuilder response = new MessageBuilder();
		String message = response.responseBuilder(MessageCodes.categoryNotFound, exception.getMessage());
		return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StoreNotFoundException.class)
	public ResponseEntity<String> storeNotFound(StoreNotFoundException exception){
		MessageBuilder response = new MessageBuilder();
		String message = response.responseBuilder(MessageCodes.storeNotFound, exception.getMessage());
		return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFound(ProductNotFoundException exception){
		MessageBuilder response = new MessageBuilder();
		String message = response.responseBuilder(MessageCodes.productNotFound, exception.getMessage());
		return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RoleIsNotValidException.class)
	public ResponseEntity<String> roleIsNotValidException(RoleIsNotValidException exception){
		MessageBuilder response = new MessageBuilder();
		String message = response.responseBuilder(MessageCodes.roleNotValid, exception.getMessage());
		return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundException(UserNotFoundException exception){
		MessageBuilder response = new MessageBuilder();
		String message = response.responseBuilder(MessageCodes.userNotFound, exception.getMessage());
		return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
	}
	

}
