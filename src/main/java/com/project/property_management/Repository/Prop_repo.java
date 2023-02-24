package com.project.property_management.Repository;

import org.springframework.data.repository.CrudRepository;

import com.project.property_management.Enity.Property_entity;

public interface Prop_repo extends CrudRepository<Property_entity, Long>{

}
