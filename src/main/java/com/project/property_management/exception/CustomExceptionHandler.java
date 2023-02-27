package com.project.property_management.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv) {
		List<ErrorModel> errorList=new ArrayList<>();
		List<FieldError> fieldErrorList=manv.getBindingResult().getFieldErrors();
		for(FieldError fe:fieldErrorList) {
			ErrorModel error=new ErrorModel();
			error.setCode(fe.getField());
			error.setMessage(fe.getDefaultMessage());
			errorList.add(error);
			
		}
		ResponseEntity<List<ErrorModel>>  re=new ResponseEntity<>(errorList,HttpStatus.BAD_REQUEST);
		return re;
		
	}
	@ExceptionHandler(BuisnessException.class)
     public ResponseEntity<List<ErrorModel>> handleBusinessException(BuisnessException bex) {
		System.out.println("BuisnessException is thrown");
		ResponseEntity<List<ErrorModel>>  re=new ResponseEntity<>(bex.getErrors(),HttpStatus.BAD_REQUEST);
		return re;
	}
}
