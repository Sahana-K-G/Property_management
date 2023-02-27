package com.project.property_management.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.project.property_management.Enity.User_entity;

public interface User_repo extends CrudRepository<User_entity, Long> {
 Optional<User_entity> findByOwneremailAndPassword(String email,String password);
 Optional<User_entity> findByOwneremail(String email);
}
