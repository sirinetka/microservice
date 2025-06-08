package com.exmple.Auth;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class User {
  @Id @GeneratedValue
  public Long id;
  public String username;
  private String name;
  private String adresse;
  public String password;
  public String role;
  
  
  
  
  
public Long getId() {
	return id;
}





public void setId(Long id) {
	this.id = id;
}





public String getUsername() {
	return username;
}





public void setUsername(String username) {
	this.username = username;
}





public String getName() {
	return name;
}





public void setName(String name) {
	this.name = name;
}





public String getAdresse() {
	return adresse;
}





public void setAdresse(String adresse) {
	this.adresse = adresse;
}





public String getPassword() {
	return password;
}





public void setPassword(String password) {
	this.password = password;
}





public String getRole() {
	return role;
}





public void setRole(String role) {
	this.role = role;
}





@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", name=" + name + ", adresse=" + adresse + ", role=" + role
			+ "]";
}
  
  
}

