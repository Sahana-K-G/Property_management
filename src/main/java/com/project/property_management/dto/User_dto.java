package com.project.property_management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class User_dto {
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String owner;
	@NotNull(message="Owner Email is Mandatory")
	@NotEmpty(message="Email can't be empty")
	private String owneremail;
	@NotNull(message="Password is Mandatory")
	@NotEmpty(message="Password can't be empty")
	@Size(min=1 ,max=10,message="password cannot be more than 10 letters" )
	private String password;
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
