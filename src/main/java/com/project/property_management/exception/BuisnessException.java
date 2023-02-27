package com.project.property_management.exception;

import java.util.List;

public class BuisnessException extends RuntimeException {
   List<ErrorModel> errors;

public BuisnessException(List<ErrorModel> errors) {
	super();
	this.errors = errors;
}

public List<ErrorModel> getErrors() {
	return errors;
}

public void setErrors(List<ErrorModel> errors) {
	this.errors = errors;
}

@Override
public String toString() {
	return "BuisnessException [errors=" + errors + "]";
}
   
   
}
