package com.project.property_management.dto;



public class property_dto {
 private long id;
 private String title;
 private String description;
 private String owner;
 private String owneremail;
 private double price;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getOwner() {
	return owner;
}
public void setOwner(String owner) {
	this.owner = owner;
}
public String getOwneremail() {
	return owneremail;
}
public void setOwneremail(String owneremail) {
	this.owneremail = owneremail;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
 
}
