package com.project.property_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.project.property_management.Service.User_service;
import com.project.property_management.dto.User_dto;

@RestController
@RequestMapping("api/v1/user")
public class User_controller {
  @Autowired
  User_service service;
  @PostMapping("/register")
  public ResponseEntity<User_dto> register_usr(@RequestBody User_dto u_dto) {
	 u_dto= service.register(u_dto);
	  ResponseEntity<User_dto> re=new ResponseEntity<>(u_dto,HttpStatus.CREATED);
	  return re;
	 
  }
  
  
}
