package com.project.property_management.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.property_management.Converter.User_converter;

import com.project.property_management.Enity.User_entity;
import com.project.property_management.Repository.User_repo;
import com.project.property_management.dto.User_dto;
@Service
public class User_service_impl implements User_service {
 
	@Autowired
	User_repo repo;
	@Autowired
	User_converter u_convert;
	@Override
	public User_dto register(User_dto user_dto) {
		// TODO Auto-generated method stub
		User_entity ue=u_convert.convertDTOtoEntity(user_dto);
		ue=repo.save(ue);
		user_dto=u_convert.converEntitytoDTO(ue);
		return user_dto;
	}

}
