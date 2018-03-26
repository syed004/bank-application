package com.bellinfo.spring.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginCredentials {
	@Override
	public String toString() {
		return "LoginCredentials [name=" + name + ", password=" + password + "]";
	}
	@NotEmpty
    @Size(min=4, max=15)
    @NotNull
	String name;
	@NotEmpty
    @Size(min=4, max=15)
    @NotNull
	String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
