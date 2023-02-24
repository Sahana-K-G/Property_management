package com.project.property_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.property_management.Service.PropertySave;
import com.project.property_management.dto.property_dto;

import lombok.Value;

@RestController
@RequestMapping("/api/v1/properties")
public class property_controller {
	
 @Autowired
 private PropertySave prop_save;
	
@GetMapping("/hello")
 public String hello() {
	 return "hello thrisha";
 }
 @PostMapping("/save")
 public ResponseEntity<property_dto> saveproperty(@RequestBody property_dto prop_dto)
 {
	 prop_dto=prop_save.saveproperty(prop_dto);//sent prop_dto(doesn't had id cuz its incremented in db) object is from cleint recieved (or returned )prop_dto is from service layer along with id)
	 ResponseEntity<property_dto> responseEntity=new ResponseEntity<>(prop_dto,HttpStatus.CREATED);
	 return responseEntity;
 }
 @GetMapping("/get")
 public ResponseEntity<List<property_dto>> getproperty()
 {
	 List<property_dto> propDtolist=prop_save.getproperty();//sent prop_dto(doesn't had id cuz its incremented in db) object is from cleint recieved (or returned )prop_dto is from service layer along with id)
	 ResponseEntity<List<property_dto>> responseEntity=new ResponseEntity<>(propDtolist,HttpStatus.CREATED);
	 return responseEntity;
 }
 

 @PutMapping("/update/{id}")
 public ResponseEntity<property_dto> updateproperty(@RequestBody property_dto prop_dto,@PathVariable long id) {
	 prop_dto=prop_save.updateproperty(prop_dto, id);
	 ResponseEntity<property_dto> responseEntity=new ResponseEntity<>(prop_dto,HttpStatus.OK);
	 return responseEntity;
	 
 }
 @PatchMapping("/update-price/{id}")
 public ResponseEntity<property_dto> updateprice(@RequestBody property_dto prop_dto,@PathVariable long id) {
	 prop_dto=prop_save.updateprice(prop_dto, id);
	 ResponseEntity<property_dto> responseEntity=new ResponseEntity<>(prop_dto,HttpStatus.OK);
	 return responseEntity;
	 
 }
 @DeleteMapping("/delete/{id}")
 public void delete(@PathVariable long id) {
	 prop_save.deleteproperty(id);
 }
}
 