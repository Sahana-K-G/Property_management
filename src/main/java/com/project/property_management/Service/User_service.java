package com.project.property_management.Service;

import com.project.property_management.dto.User_dto;

public interface User_service {
 User_dto register(User_dto user_dto);
 User_dto login(String useremail,String password);
}
