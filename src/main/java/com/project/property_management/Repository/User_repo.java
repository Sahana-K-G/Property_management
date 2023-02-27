package com.project.property_management.Repository;

import org.springframework.data.repository.CrudRepository;

import com.project.property_management.Enity.User_entity;

public interface User_repo extends CrudRepository<User_entity, Long> {

}
