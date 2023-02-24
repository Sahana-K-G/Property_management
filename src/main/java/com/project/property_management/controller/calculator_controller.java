package com.project.property_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.property_management.dto.calculator_dto;

//methods to fetch value from client
@RestController
@RequestMapping("/api/v1/calculator")
public class calculator_controller {
	@GetMapping("/add")
	 //1@RequestParam http://localhost:8089/api/v1/calculator/add?num1=9.2&num2=9.0
	 public Double add(@RequestParam("num1")Double n1,@RequestParam("num2")Double n2) {
		return n1+n2;
		 
	 }
	 @GetMapping("/sub/{n1}/{n2}")
	 //1@PathVariable http://localhost:8089/api/v1/calculator/sub/10.0/8.9
	 public Double sub(@PathVariable("n1")Double n1,@PathVariable("n2")Double n2) {
		if(n1>n2)
		{
			return n1-n2;
		}
		else
			return n2-n1;
	 }
	 @PostMapping("/mul")
	
	 public Double mul(@RequestBody calculator_dto cal) {
		return cal.getN1()*cal.getN2();
		 
	 }
}
