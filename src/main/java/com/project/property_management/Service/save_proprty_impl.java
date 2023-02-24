package com.project.property_management.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.property_management.Converter.Property_convert;
import com.project.property_management.Enity.Property_entity;
import com.project.property_management.Repository.Prop_repo;
import com.project.property_management.dto.property_dto;
@Service
public class save_proprty_impl implements PropertySave{
	@Autowired
	private Prop_repo repo;
	@Autowired
	private Property_convert prop_convert;
	//service layer gets prop_dto object buy repo wants prop_entity object so conversion
	//service layer returns dto object so conversion is needed
	@Override
	public property_dto saveproperty(property_dto prop_dto) {
		Property_entity pe=prop_convert.convertDTOtoEntity(prop_dto);
		pe=repo.save(pe);//the saved object from db is retrned and given back to controller after converting to dto
		prop_dto=prop_convert.converEntitytoDTO(pe);//conversion
		return prop_dto;
	}
	@Override
	public List<property_dto> getproperty() {
		List<Property_entity> list_prop=(List<Property_entity>) repo.findAll();//gets data from db
		List<property_dto> list_prop_dto=new ArrayList<>();
		for(Property_entity pe:list_prop) {
			property_dto prop_dto=prop_convert.converEntitytoDTO(pe);
			list_prop_dto.add(prop_dto);
			
		}
		return list_prop_dto;//returns to controlller
	}
	@Override
	public property_dto updateproperty(property_dto prop_dto, long id) {
	java.util.Optional<Property_entity> optn=repo.findById(id);
	property_dto dto=null;
		if(optn.isPresent()) {
			Property_entity pe=optn.get();
			pe.setTitle(prop_dto.getTitle());
			pe.setDescription(prop_dto.getDescription());
			pe.setOwner(prop_dto.getOwner());
			pe.setOwneremail(prop_dto.getOwneremail());
			pe.setPrice(prop_dto.getPrice());
		dto=prop_convert.converEntitytoDTO(pe);
			repo.save(pe);
		}
		
		return dto;
	}
	@Override
	public property_dto updateprice(property_dto prop_dto, long id) {
		java.util.Optional<Property_entity> optn=repo.findById(id);
		property_dto dto=null;
			if(optn.isPresent()) {
				Property_entity pe=optn.get();
				pe.setPrice(prop_dto.getPrice());
			dto=prop_convert.converEntitytoDTO(pe);
				repo.save(pe);
			}
			
			return dto;
	}
	@Override
	public void deleteproperty(long id) {
		repo.deleteById(id);
		
	}

}
