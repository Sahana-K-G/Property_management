package com.project.property_management.Converter;

import org.springframework.stereotype.Component;

import com.project.property_management.Enity.Property_entity;
import com.project.property_management.dto.property_dto;
@Component
public class Property_convert {
  
	public Property_entity convertDTOtoEntity(property_dto prop_dto) {
		//service layer gets prop_dto object buy repo wants prop_entity object so conversion
				Property_entity pe=new Property_entity();
				pe.setTitle(prop_dto.getTitle());
				pe.setDescription(prop_dto.getDescription());
				pe.setOwner(prop_dto.getOwner());
				pe.setOwneremail(prop_dto.getOwneremail());
				pe.setPrice(prop_dto.getPrice());
				return pe;
	}
	public property_dto converEntitytoDTO(Property_entity prop_entity) {
		//service layer returns dto object so conversion is needed
				property_dto dto=new property_dto();
				dto.setId(prop_entity.getId());
				dto.setTitle(prop_entity.getTitle());
				dto.setDescription(prop_entity.getDescription());
				dto.setOwner(prop_entity.getOwner());
				dto.setOwneremail(prop_entity.getOwneremail());
				dto.setPrice(prop_entity.getPrice());
				return dto;
	}

}
