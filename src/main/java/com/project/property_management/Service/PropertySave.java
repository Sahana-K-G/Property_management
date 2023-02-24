package com.project.property_management.Service;


import java.util.List;

import com.project.property_management.dto.property_dto;

public interface PropertySave {
	
   property_dto saveproperty(property_dto prop_dto);
  List<property_dto> getproperty();
  property_dto updateproperty(property_dto prop_dto,long id);

  property_dto updateprice(property_dto prop_dto,long id);
  void deleteproperty(long id);
}
