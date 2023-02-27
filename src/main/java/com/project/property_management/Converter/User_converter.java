package com.project.property_management.Converter;


import org.springframework.stereotype.Component;

import com.project.property_management.Enity.User_entity;
import com.project.property_management.dto.User_dto;

@Component
public class User_converter {
	public User_entity convertDTOtoEntity(User_dto u_dto) {
		User_entity ue=new User_entity();
		ue.setOwner(u_dto.getOwner());
		ue.setOwneremail(u_dto.getOwneremail());
		ue.setPassword(u_dto.getPassword());
		return ue;
	}
	public User_dto converEntitytoDTO(User_entity ue) {
		//service layer returns dto object so conversion is needed
		User_dto u_dto=new User_dto();
		u_dto.setId(ue.getId());
		u_dto.setOwner(ue.getOwner());
		u_dto.setOwneremail(ue.getOwneremail());
		
		return u_dto;
	}

}
