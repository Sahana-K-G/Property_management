package com.project.property_management.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.property_management.Converter.User_converter;

import com.project.property_management.Enity.User_entity;
import com.project.property_management.Repository.User_repo;
import com.project.property_management.dto.User_dto;
import com.project.property_management.exception.BuisnessException;
import com.project.property_management.exception.ErrorModel;
@Service
public class User_service_impl implements User_service {
 
	@Autowired
	User_repo repo;
	@Autowired
	User_converter u_convert;
	@Override
	public User_dto register(User_dto user_dto) {
		// TODO Auto-generated method stub
		Optional<User_entity> opue=repo.findByOwneremail(user_dto.getOwneremail());
		if(opue.isPresent()) {
			List<ErrorModel> errorList=new ArrayList<>();
			ErrorModel error=new ErrorModel();
			error.setCode("Invalid Signin");
			error.setMessage("Email already exist");
			errorList.add(error);
			throw new BuisnessException(errorList);
		}
		User_entity ue=u_convert.convertDTOtoEntity(user_dto);
		ue=repo.save(ue);
		user_dto=u_convert.converEntitytoDTO(ue);
		return user_dto;
	}
	@Override
	public User_dto login(String useremail, String password) {
		// TODO Auto-generated method stub
		User_dto user_dto=null;
		Optional<User_entity> oe=repo.findByOwneremailAndPassword(useremail, password);
		if(oe.isPresent()) {
			user_dto=u_convert.converEntitytoDTO(oe.get());
		}else {
			List<ErrorModel> errorList=new ArrayList<>();
			ErrorModel error=new ErrorModel();
			error.setCode("Invalid Login");
			error.setMessage("Username or Passsword doesn't exist");
			errorList.add(error);
			throw new BuisnessException(errorList);
		}
		return user_dto;
	}

}
