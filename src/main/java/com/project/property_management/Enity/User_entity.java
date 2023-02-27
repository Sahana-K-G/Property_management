package com.project.property_management.Enity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User_table")
public class User_entity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String owner;
	private String owneremail;
	private String password;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
